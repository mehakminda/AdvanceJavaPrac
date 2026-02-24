package com.learning.telusko;

import com.learning.telusko.bo.JobSeekerProfile;
import com.learning.telusko.service.JobSeekerServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.*;
import java.util.Optional;

@SpringBootApplication
public class SpringDataJpa10JobSeekerAppLobApplication {

	public static void main(String[] args) throws IOException {
		ConfigurableApplicationContext context =SpringApplication.run(SpringDataJpa10JobSeekerAppLobApplication.class, args);
		JobSeekerServiceImpl service=context.getBean(JobSeekerServiceImpl.class);
		InputStream input=null;
		FileReader reader=null;
		byte image[]=null;
		char textFile[]=null;

     /*   try {
            // input=new FileInputStream("C:\\learning\\teluskojava\\spring\\SpringJDBC\\SpringDataJPA10JobSeekerApp_LOB\\src\\main\\resources\\testdata\\cute_krishna.jpg");
			//input=new FileInputStream("C:\\learning\\teluskojava\\spring\\SpringJDBC\\SpringDataJPA10JobSeekerApp_LOB\\src\\main\\resources\\testdata\\God.jpg"); //
			//input=new FileInputStream("C:\\learning\\teluskojava\\spring\\SpringJDBC\\SpringDataJPA10JobSeekerApp_LOB\\src\\main\\resources\\testdata\\dan.jpg");
			//-> used to read bytestream
			image= new byte[input.available()];
			input.read(image);

			File file=new File("C:\\learning\\teluskojava\\spring\\SpringJDBC\\SpringDataJPA10JobSeekerApp_LOB\\src\\main\\resources\\testdata\\Sample.txt");
			 reader = new FileReader(file); //used to read files having characters
			textFile=new char[(int) file.length()];
			reader.read(textFile);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
		catch (Exception e){
			e.printStackTrace();
		}
		finally {
            try {
                input.close();
				reader.close();
            } catch (IOException e) {
               e.printStackTrace();
            }

		}*/

		//System.out.println(service.registerJobSeeker(new JobSeekerProfile("Krishna", "Vrindavan",image, textFile )));
		//System.out.println(service.registerJobSeeker(new JobSeekerProfile("Jesus", "jerusalem",image, textFile )));
		//System.out.println(service.registerJobSeeker(new JobSeekerProfile("Daniel", "London",image, textFile )));

		/* co pilot answer for reading file directly from resource folder
				try {
			// Read image as byte[]
			InputStream imgStream = SpringDataJpa10JobSeekerAppLobApplication.class.getClassLoader().getResourceAsStream("testdata/cute_krishna.jpg");
			byte[] imageBytes = null;
			if (imgStream != null) {
				imageBytes = imgStream.readAllBytes();
				imgStream.close();
			}
			// Read text file as char[]
			InputStream txtStream = SpringDataJpa10JobSeekerAppLobApplication.class.getClassLoader().getResourceAsStream("testdata/Sample.txt");
			char[] textChars = null;
			if (txtStream != null) {
				StringBuilder sb = new StringBuilder();
				try (BufferedReader reader = new BufferedReader(new InputStreamReader(txtStream, StandardCharsets.UTF_8))) {
					int c;
					while ((c = reader.read()) != -1) {
						sb.append((char) c);
					}
				}
				textChars = sb.toString().toCharArray();
			}
			// Create JobSeekerProfile
			JobSeekerProfile profile = new JobSeekerProfile("Krishna", "Vrindavan", imageBytes, textChars);
			System.out.println(sevice.registerJobSeeker(profile));
		} catch (IOException e) {
			e.printStackTrace();
		}*/


		//Data- retrieval

		Optional<JobSeekerProfile> jobSeekerProfileOptional=service.getDetailsById(1);
		if(jobSeekerProfileOptional.isPresent()){
				JobSeekerProfile jobSeekerProfile=jobSeekerProfileOptional.get();
			System.out.println(jobSeekerProfile.getId()+" -> "+jobSeekerProfile.getName()+" -> "+jobSeekerProfile.getCity());

			OutputStream output=new FileOutputStream("Output-image.jpg"); //ducded the exception
			output.write(jobSeekerProfile.getImage());
			output.flush();

			FileWriter writer= new FileWriter("output.txt");
			writer.write(jobSeekerProfile.getTextFile());
			writer.flush();
		}
		else{
			System.out.println("No record with given id");
		}

	//	service.getAllJobSeeker().forEach(data -> System.out.println(data));

	}

}


