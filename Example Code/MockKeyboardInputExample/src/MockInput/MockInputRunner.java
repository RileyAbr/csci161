/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MockInput;

/**
 *
 * @author araderma
 */
public class MockInputRunner 
{
    public static void main(String[] args) 
    {
        String[] input = {"Bob", "22", "3.5", "Red"}; 
        
        MockInputStream keyboardSimulator = new MockInputStream(input, System.out, 750);
        
        System.setIn(keyboardSimulator);
        
        // Call the main method for the class you want to simulate input to
        ExampleMain.ExampleClient.main(args);
    }
}
