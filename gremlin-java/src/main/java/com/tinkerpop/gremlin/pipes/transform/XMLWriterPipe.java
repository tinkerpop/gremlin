package com.tinkerpop.gremlin.pipes.transform;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Vector;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.pipes.AbstractPipe;
import com.tinkerpop.pipes.sideeffect.SideEffectPipe;
import com.tinkerpop.pipes.util.AsPipe;
import com.tinkerpop.pipes.util.Pipeline;

public class XMLWriterPipe extends AbstractPipe<Vertex, Vertex> implements SideEffectPipe<Vertex, XMLStreamWriter> {

	private XMLStreamWriter writer;
	private String xmlNodeName;
	private String[] propertyNames;
	private boolean hasOpenElement = false;
	public List<XMLWriterPipe> followingXMLWriterPipes = new Vector<XMLWriterPipe>();
	
	public XMLWriterPipe(XMLStreamWriter aWriter, String anXMLNodeName, String[] somePropertyNames,
			List<XMLWriterPipe> previousXMLWriterPipes) {		
		writer = aWriter;
		xmlNodeName = anXMLNodeName;
		propertyNames = somePropertyNames;
		for (XMLWriterPipe aPreviousWriter : previousXMLWriterPipes) {
			aPreviousWriter.followingXMLWriterPipes.add(this);
		}
	}
	
	
	@Override
	public XMLStreamWriter getSideEffect() {
		return writer;
	}

	
	public void closeElementIfNeeded() {
		try {
			if (hasOpenElement) {
				writer.writeEndElement();
				hasOpenElement = false;
			}
			for (XMLWriterPipe aFollowingWriter : followingXMLWriterPipes) {
				aFollowingWriter.closeElementIfNeeded();
			}			
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}    				
	}
	
	
	@Override
    public void finishIteration() {	
		// if there are no more elements in the pipe, the last element still has to be closed, 
		// because iterators in a for-loop do not call a final next() this has to be done here
		closeElementIfNeeded();
		super.finishIteration();
    }
    

	@Override
	public Vertex next() {
		// every time a new element is startet the last one has to be closed
		// only the first time this has not to be done
		// get the next element like a normal sideEffect pipeline
		closeElementIfNeeded();
		Vertex currentElement = super.next();
		if (currentElement != null) {
			try {
				writer.writeStartElement(xmlNodeName);
				hasOpenElement = true;
				// write alle the desired attributes
				for (String anAttribute : propertyNames) {
					Object aPropObject = currentElement.getProperty(anAttribute);
					if (aPropObject instanceof String) {
						String stringProp = (String) aPropObject;							
						writer.writeAttribute(anAttribute, stringProp);
					} else if (aPropObject instanceof Number) {
						Number numberProp = (Number) aPropObject;
						writer.writeAttribute(anAttribute, numberProp.toString());								
					}
				}			
			} catch (XMLStreamException e) {
				e.printStackTrace();
			}		
		}
		return currentElement;
	}

	
	@Override	
	public void reset() {
		closeElementIfNeeded();
		super.reset();
	}


	@Override
	protected Vertex processNextStart() throws NoSuchElementException {
		return starts.next();
	}


	
	
}
