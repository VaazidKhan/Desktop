package Listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	
	int counter=0;
	int limit=3;
	
	public boolean retry(ITestResult result){
		if (counter < limit) {
            System.out.println("Retrying " + result.getName() + " again and the count is " + (counter+1));
            counter++;
            return true;
        }
        return false;
    }
   
	}


