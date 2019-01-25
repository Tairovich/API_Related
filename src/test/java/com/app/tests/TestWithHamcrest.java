package com.app.tests;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;


public class TestWithHamcrest {

	
	@Test
	public void test1() {
		
		assertThat(4, equalTo(5));
		assertThat(4, is(5));
		
		assertThat(4, not(equalTo(5) )  );
		
		assertThat("abc", containsString("a"));
		
	//	asserThat("AbC",equalToIgnoringCase("abc"));
		
		assertThat(5, greaterThan(4));
		
		List<Integer> lst = Arrays.asList(2,3,4,5);
		
		assertThat(lst,hasSize(4));
		
		
		
	}
}
