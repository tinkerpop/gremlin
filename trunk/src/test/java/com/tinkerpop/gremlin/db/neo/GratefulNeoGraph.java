package com.tinkerpop.gremlin.db.neo;

import org.neo4j.api.core.*;
import org.neo4j.util.index.IndexService;
import org.neo4j.util.index.LuceneIndexService;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class GratefulNeoGraph {

    private NeoService neo;
    private IndexService index;

    public static enum DeadRelationships implements RelationshipType {
        FOLLOWED_BY, WRITTEN_BY, SUNG_BY
    }

    public static final String NEO_DIRECTORY = "/tmp/grateful_neo_graph";
    public static final String NAME = "name";
    public static final String TYPE = "type";
    public static final String PERFORMANCES = "performances";
    public static final String WEIGHT = "weight";

    public GratefulNeoGraph() {
        neo = new EmbeddedNeo(NEO_DIRECTORY);
        index = new LuceneIndexService(neo);
    }

    public NeoService getNeo() {
        return this.neo;
    }

    public IndexService getIndex() {
        return this.index;
    }

    public void loadGratefulDeadGraph() {
        deleteGraphDirectory(new File(NEO_DIRECTORY));
        neo = new EmbeddedNeo(NEO_DIRECTORY);
        index = new LuceneIndexService(neo);
        // LOAD SONG FOLLOWS GRAPH
        Transaction tx = neo.beginTx();
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(GratefulNeoGraph.class.getResourceAsStream("../song-follows-net.txt")));
            String line = input.readLine();
            while (line != null) {
                String[] edge = line.split("\t");
                Node startSong = index.getSingleNode(NAME, edge[0]);
                if (null == startSong) {
                    startSong = neo.createNode();
                    startSong.setProperty(NAME, edge[0]);
                    index.index(startSong, NAME, edge[0]);
                }

                Node endSong = index.getSingleNode(NAME, edge[1]);
                if (null == endSong) {
                    endSong = neo.createNode();
                    endSong.setProperty(NAME, edge[1]);
                    index.index(endSong, NAME, edge[1]);
                }
                if (!startSong.getProperty(NAME).equals(endSong.getProperty(NAME))) {
                    System.out.println(startSong.getProperty(NAME) + "--FOLLOWED_BY[" + new Float(edge[2]).intValue() + "]-->" + endSong.getProperty(NAME));
                    Relationship r = startSong.createRelationshipTo(endSong, DeadRelationships.FOLLOWED_BY);
                    r.setProperty(WEIGHT, new Float(edge[2]).intValue());
                }

                line = input.readLine();
            }
            input.close();
            tx.success();
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            tx.finish();
        }

        // LOAD SONG AUTHOR/SINGER NETWORK
        tx = neo.beginTx();
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(GratefulNeoGraph.class.getResourceAsStream("../author-singer-net.txt")));
            input.readLine();
            String line = input.readLine();
            while (line != null) {
                String[] data = line.split("\t");
                Node song = index.getSingleNode(NAME, data[0]);
                if (null == song) {
                    song = neo.createNode();
                    song.setProperty(NAME, data[0]);
                    song.setProperty(PERFORMANCES, new Integer(data[3]));
                    song.setProperty(TYPE, data[4]);
                    index.index(song, NAME, data[0]);
                }

                Node author = index.getSingleNode(NAME, data[1]);
                if (null == author) {
                    author = neo.createNode();
                    author.setProperty(NAME, data[1]);
                    index.index(author, NAME, data[1]);
                }

                Node singer = index.getSingleNode(NAME, data[2]);
                if (null == singer) {
                    singer = neo.createNode();
                    singer.setProperty(NAME, data[2]);
                    index.index(singer, NAME, data[2]);
                }

                System.out.println(song.getProperty(NAME) + "--WRITTEN_BY-->" + author.getProperty(NAME));
                song.createRelationshipTo(author, DeadRelationships.WRITTEN_BY);
                System.out.println(song.getProperty(NAME) + "--SUNG_BY-->" + singer.getProperty(NAME));
                song.createRelationshipTo(singer, DeadRelationships.SUNG_BY);

                line = input.readLine();
            }
            input.close();
            tx.success();
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            tx.finish();
        }

        /*tx = neo.beginTx();
        try {
            int counter = 0;
            for(Node node : neo.getAllNodes()) {
                counter++;
                System.out.println(node.getProperty(NAME));
            }
            System.out.println("Total number of nodes: " + counter);
            tx.success();

        } finally {
            tx.finish();
        }*/
    }

    public void shutdown() {
        neo.shutdown();
        index.shutdown();
    }

    private void deleteGraphDirectory(File directory) {
        if (directory.exists()) {
            for (File file : directory.listFiles()) {
                if (file.isDirectory()) {
                    deleteGraphDirectory(file);
                } else {
                    file.delete();
                }
            }
        }
    }
}
