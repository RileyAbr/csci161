package MockInput;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.Queue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author araderma
 */
public class MockInputStream extends InputStream 
{
    private Queue<String> elements; 
    private OutputStream outputStream;
    private int simulatedDelay; 
    
    private byte[] currentElement;
    private int currentIndex; 
    
    public MockInputStream()
    {
        elements = new LinkedList<>();
    }
    
    public MockInputStream(String[] input)
    {
        elements = new LinkedList<>();
        addValues(input);
    }
    
    public MockInputStream(String[] input, OutputStream os, int delay)
    {
        elements = new LinkedList<>(); 
        outputStream = os; 
        simulatedDelay = delay; 
        addValues(input);
    }
    
    public void addValue(String value)
    {
        elements.add(value + "\n"); 
    }
    
    public final void addValues(String[] values)
    {
        for(String value : values)
        {
            elements.add(value + "\n");
        }
    }
    
    public void addExactValue(String value)
    {
        elements.add(value);
    }
    
    public void addExactValues(String[] values)
    {
        for(String value : values)
        {
            elements.add(value);
        }
    }
    
    @Override
    public int read() throws IOException 
    {
        // Check if we need a new element from the queue 
        if(currentElement == null || currentIndex == currentElement.length)
        {
            if(elements.isEmpty())
            {
                return -1; 
            }
            currentElement = elements.remove().getBytes(); 
        }
        
        return currentElement[currentIndex++];
    }

    @Override
    public int read(byte[] b) throws IOException 
    {
        return read(b, 0, 0); 
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException 
    {
        // Return -1 if there's no more input to be read
        if(elements.isEmpty())
        {
            return -1; 
        }
        else
        {
            // Simulate a short delay if applicable
            long waitUntil = System.currentTimeMillis() + simulatedDelay;
            while(System.currentTimeMillis() < waitUntil)
            {
                // do nothing and wait
            }
            
            // Convert next element into bytes
            byte[] bytes = elements.remove().getBytes();
            
            // Read up to len bytes into the supplied array at indicated offset
            // Unread portions of the current element are discarded if it is not fully read
            for(int i = 0; i < bytes.length && i < len; i++)
            {
                b[i + off] = bytes[i];
            }
            
            // Echo the simulated input to an OutputStream if one exists
            if(outputStream != null)
            {
                outputStream.write(bytes);
            }

            return bytes.length; 
        }
    }
    
    
    
    
    
}
