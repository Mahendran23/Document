package com.examples;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.timeout;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTesterwithMockMethod {
	
   private MathApplication mathApplication;
   private CalculatorService calcService;

   @Before
   public void setUp(){
      mathApplication = new MathApplication();
      calcService = mock(CalculatorService.class);
      mathApplication.setCalculatorService(calcService);
   }

   @Test
   public void testAddAndSubtract(){

      //add the behavior to add numbers
      when(calcService.add(20.0,10.0)).thenReturn(30.0);

      //subtract the behavior to subtract numbers
      when(calcService.subtract(20.0,10.0)).thenReturn(10.0);

      //test the subtract functionality
      Assert.assertEquals(mathApplication.subtract(20.0, 10.0),10.0,0);

      //test the add functionality
      Assert.assertEquals(mathApplication.add(20.0, 10.0),30.0,0);

      //verify call to calcService is made or not
      verify(calcService).add(20.0,10.0);
      verify(calcService).subtract(20.0,10.0);
   }
   
   // Testing the reset functionality.
   @Test
   public void testResetFun(){

      //add the behavior to add numbers
      when(calcService.add(20.0,10.0)).thenReturn(30.0);
  
      //test the add functionality
      Assert.assertEquals(mathApplication.add(20.0, 10.0),30.0,0);

      //reset the mock	  
      reset(calcService);

      //test the add functionality after resetting the mock
      Assert.assertEquals(mathApplication.add(20.0, 10.0),30.0,0);   
   }
   
   // Test time out functionality.
   @Test
   public void testTimeOutFun(){

      //add the behavior to add numbers
      when(calcService.add(20.0,10.0)).thenReturn(30.0);

      //subtract the behavior to subtract numbers
      when(calcService.subtract(20.0,10.0)).thenReturn(10.0);

      //test the subtract functionality
      Assert.assertEquals(mathApplication.subtract(20.0, 10.0),10.0,0);

      //test the add functionality
      Assert.assertEquals(mathApplication.add(20.0, 10.0),30.0,0);

      //verify call to add method to be completed within 100 ms
      verify(calcService, timeout(100)).add(20.0,10.0);
	  
      //invocation count can be added to ensure multiplication invocations
      //can be checked within given timeframe
      verify(calcService, timeout(100).times(1)).subtract(20.0,10.0);
   }

}