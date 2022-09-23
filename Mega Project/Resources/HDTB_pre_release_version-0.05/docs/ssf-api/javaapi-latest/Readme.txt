			ReadMe

Software Requirements:
		
		jdk1.6 or higher version


Directory contents:
		javadoc
		Sanchay
		SSFExamples.java
		testdata
		ReadMe.txt
		SSFAPI.rtf 

How to Use:

	1: Extract the tar ball into your Home Directory.

	2: change the hardcode path in SSFExamples.java line no. 60, 63 and 65.
	
	3: Complie the SSFExamples.java by using the following command:
	
		 javac -cp .:Sanchay/dist/Sanchay.jar  SSFExamples.java

	4: Run the SSFExamples.java by using following command:
		
		java -cp .:Sanchay/dist/Sanchay.jar SSFExamples <input_file_name>
		
		e.g:
		
		java -cp .:Sanchay/dist/Sanchay.jar SSFExamples testdata/sent1_1.lwgutf.out


For API help:
		Small documentation inside the javaapi Directory
		
		Open javadoc directory and open index.html 		
			
		Small writeup of SSF API is SSF_API.doc
