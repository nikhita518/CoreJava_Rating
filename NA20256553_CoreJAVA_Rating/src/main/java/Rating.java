import java.io.*;
import java.util.*;

public class Rating
{
	public static void displayAssignmentCategory(Dictionary<String,Integer> assignmentCategory)
	{
		Enumeration<String> Keys = assignmentCategory.keys();
		Enumeration<Integer> Value = assignmentCategory.elements();
		while (Keys.hasMoreElements()) {
			System.out.println(Keys.nextElement()+" "+Value.nextElement());
		}
	}
	
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		//Input
		Dictionary<String,Integer> assignmentCategory = new Hashtable<String,Integer>();
		assignmentCategory.put("Test",40);
		assignmentCategory.put("Quiz",20);
		assignmentCategory.put("Labwork",10);
		assignmentCategory.put("Project",30);
		ArrayList<ArrayList<String>> StudentsData = new ArrayList();
		while(true)
		{
			System.out.println("1.Insert Student Assignment Data.\n2.Student Average Score.\n3.Subject Average Score.");
			System.out.println("NOTE: Initial data needed to be entered to perform other operations.");
			int choice = scan.nextInt();
			switch(choice)
			{
				case 1: System.out.println("Enter the number of entries to be inserted");
						int nEntries = scan.nextInt();
						for(int i=0;i<nEntries;i++)
						{
							//Add ith row
							StudentsData.add(new ArrayList<String>());
							//ith row elements
							System.out.println("Enter Student name: ");
							String name = scan.next();
							scan.nextLine();
							StudentsData.get(i).add(0,name);
							System.out.println("Enter Subject name: ");
							String subject = scan.nextLine();
							StudentsData.get(i).add(1,subject);
							System.out.println("Enter Assignment name: ");
							String aName = scan.nextLine();
							StudentsData.get(i).add(2,aName);
							System.out.println("Enter Date of submission: ");
							String date = scan.nextLine();
							StudentsData.get(i).add(3,date);
							System.out.println("Enter Score: ");
							String score = scan.nextLine();
							StudentsData.get(i).add(4,score);
						}
					break;
				case 2: if(StudentsData.size() == 0)
						{
							System.out.println("Please enter the data first");
							break;
						}
						System.out.println("Enter the Student Name");
						String sName = scan.next();
						ArrayList<ArrayList<String>> subject = new ArrayList();
						for(int i=0;i<StudentsData.size();i++)
						{
							int index = 0;
							if(StudentsData.get(i).get(0).equals(sName))
							{
								if(subject.size() == 0)
								{
									subject.add(new ArrayList<String>());
									subject.get(0).add(0,StudentsData.get(i).get(1));
									if(StudentsData.get(i).get(2).contains("test"))
									{
										subject.get(0).add(1,StudentsData.get(i).get(4));
										subject.get(0).add(2,"1");
									}
									if(StudentsData.get(i).get(2).contains("quiz"))
									{
										subject.get(0).add(3,StudentsData.get(i).get(4));
										subject.get(0).add(4,"1");
										
									}
									if(StudentsData.get(i).get(2).contains("labwork"))
									{
										subject.get(0).add(5,StudentsData.get(i).get(4));
										subject.get(0).add(6,"1");
									}
									if(StudentsData.get(i).get(2).contains("project"))
									{
										subject.get(0).add(7,StudentsData.get(i).get(4));
										subject.get(0).add(8,"1");
									}
								}
								else
								{
									for(int j = 0;j<subject.size();j++)
									{
										if(StudentsData.get(i).get(1).equals(subject.get(j).get(0)))
										{
											int sum = 0;
											if(StudentsData.get(i).get(2).contains("test"))
											{
												sum = sum+Integer.valueOf(subject.get(j).get(1))+Integer.valueOf(StudentsData.get(i).get(4));
												subject.get(j).set(1,String.valueOf(sum));
												int add = Integer.valueOf(subject.get(j).get(2))+1;
												subject.get(0).add(2,String.valueOf(add));
											}
											else if(StudentsData.get(i).get(2).contains("quiz"))
											{
												sum = sum+Integer.valueOf(subject.get(j).get(3))+Integer.valueOf(StudentsData.get(i).get(4));
												subject.get(j).set(3,String.valueOf(sum));
												int add = Integer.valueOf(subject.get(j).get(4))+1;
												subject.get(0).add(4,String.valueOf(add));
											}
											else if(StudentsData.get(i).get(2).contains("labwork"))
											{
												sum = sum+Integer.valueOf(subject.get(j).get(5))+Integer.valueOf(StudentsData.get(i).get(4));
												subject.get(j).add(5,String.valueOf(sum));
												int add = Integer.valueOf(subject.get(j).get(6))+1;
												subject.get(0).add(6,String.valueOf(add));
											}
											else if(StudentsData.get(i).get(2).contains("project"))
											{
												sum = sum+Integer.valueOf(subject.get(j).get(7))+Integer.valueOf(StudentsData.get(i).get(4));
												subject.get(j).add(7,String.valueOf(sum));
												int add = Integer.valueOf(subject.get(j).get(8))+1;
												subject.get(0).add(8,String.valueOf(add));
											}
										}
									}
									index = subject.size();
									subject.add(new ArrayList<String>());
									subject.get(index).add(0,StudentsData.get(i).get(1));
									if(StudentsData.get(i).get(2).contains("test"))
									{
										subject.get(index).add(1,StudentsData.get(i).get(4));
										subject.get(index).add(2,"1");
									}
									if(StudentsData.get(i).get(2).contains("quiz"))
									{
										subject.get(index).add(3,StudentsData.get(i).get(4));
										subject.get(index).add(4,"1");
									}
									if(StudentsData.get(i).get(2).contains("labwork"))
									{
										subject.get(index).add(5,StudentsData.get(i).get(4));
										subject.get(index).add(6,"1");
									}
									if(StudentsData.get(i).get(2).contains("project"))
									{
										subject.get(index).add(7,StudentsData.get(i).get(4));
										subject.get(index).add(8,"1");
									}
									
								}
							}
						}
						System.out.println("Subject Name\tTest\tQuiz\tLabwork\tProject\tOverallRating");
						for(int i=0;i<subject.size();i++)
						{
							int Test = 0,Quiz = 0,Labwork = 0,Project = 0;
							if(Integer.valueOf(subject.get(i).get(2)) != 0)
								Test = (assignmentCategory.get("Test")*Integer.valueOf(subject.get(i).get(1)))/(Integer.valueOf(subject.get(i).get(2))*100);
							if(Integer.valueOf(subject.get(i).get(4)) != 0)
								Quiz = (assignmentCategory.get("Quiz")*Integer.valueOf(subject.get(i).get(3)))/(Integer.valueOf(subject.get(i).get(4))*100);
							if(Integer.valueOf(subject.get(i).get(6)) != 0)
								Labwork = (assignmentCategory.get("Labwork")*Integer.valueOf(subject.get(i).get(5)))/(Integer.valueOf(subject.get(i).get(6))*100);
							if(Integer.valueOf(subject.get(i).get(8)) != 0)
								Project = (assignmentCategory.get("Project")*Integer.valueOf(subject.get(i).get(7)))/(Integer.valueOf(subject.get(i).get(8))*100);
							System.out.println(subject.get(i).get(0)+"\t"+Test+"\t"+Quiz+"\t"+Labwork+"\t"+Project+"\t"+(Test+Quiz+Labwork+Project));
						}
					break;
				case 3: if(StudentsData.size() == 0)
						{
							System.out.println("Please enter the data first");
							break;
						}
						System.out.println("Enter the Subject Name");
						String suName = scan.next();
						ArrayList<ArrayList<String>> student = new ArrayList();
						for(int i=0;i<StudentsData.size();i++)
						{
							int index = 0;
							if(StudentsData.get(i).get(1).equals(suName))
							{
								if(student.size() == 0)
								{
									student.add(new ArrayList<String>());
									student.get(0).add(0,StudentsData.get(i).get(0));
									if(StudentsData.get(i).get(2).contains("test"))
									{
										student.get(0).add(1,StudentsData.get(i).get(4));
										student.get(0).add(2,"1");
									}
									if(StudentsData.get(i).get(2).contains("quiz"))
									{
										student.get(0).add(3,StudentsData.get(i).get(4));
										student.get(0).add(4,"1");
										
									}
									if(StudentsData.get(i).get(2).contains("labwork"))
									{
										student.get(0).add(5,StudentsData.get(i).get(4));
										student.get(0).add(6,"1");
									}
									if(StudentsData.get(i).get(2).contains("project"))
									{
										student.get(0).add(7,StudentsData.get(i).get(4));
										student.get(0).add(8,"1");
									}
								}
								else
								{
									for(int j = 0;j<student.size();j++)
									{
										if(StudentsData.get(i).get(0).equals(student.get(j).get(0)))
										{
											int sum = 0;
											if(StudentsData.get(i).get(2).contains("test"))
											{
												sum = sum+Integer.valueOf(student.get(j).get(1))+Integer.valueOf(StudentsData.get(i).get(4));
												student.get(j).set(1,String.valueOf(sum));
												int add = Integer.valueOf(student.get(j).get(2))+1;
												student.get(0).add(2,String.valueOf(add));
											}
											else if(StudentsData.get(i).get(2).contains("quiz"))
											{
												sum = sum+Integer.valueOf(student.get(j).get(3))+Integer.valueOf(StudentsData.get(i).get(4));
												student.get(j).set(3,String.valueOf(sum));
												int add = Integer.valueOf(student.get(j).get(4))+1;
												student.get(0).add(4,String.valueOf(add));
											}
											else if(StudentsData.get(i).get(2).contains("labwork"))
											{
												sum = sum+Integer.valueOf(student.get(j).get(5))+Integer.valueOf(StudentsData.get(i).get(4));
												student.get(j).add(5,String.valueOf(sum));
												int add = Integer.valueOf(student.get(j).get(6))+1;
												student.get(0).add(6,String.valueOf(add));
											}
											else if(StudentsData.get(i).get(2).contains("project"))
											{
												sum = sum+Integer.valueOf(student.get(j).get(7))+Integer.valueOf(StudentsData.get(i).get(4));
												student.get(j).add(7,String.valueOf(sum));
												int add = Integer.valueOf(student.get(j).get(8))+1;
												student.get(0).add(8,String.valueOf(add));
											}
										}
									}
									index = student.size();
									student.add(new ArrayList<String>());
									student.get(index).add(0,StudentsData.get(i).get(0));
									if(StudentsData.get(i).get(2).contains("test"))
									{
										student.get(index).add(1,StudentsData.get(i).get(4));
										student.get(index).add(2,"1");
									}
									if(StudentsData.get(i).get(2).contains("quiz"))
									{
										student.get(index).add(3,StudentsData.get(i).get(4));
										student.get(index).add(4,"1");
									}
									if(StudentsData.get(i).get(2).contains("labwork"))
									{
										student.get(index).add(5,StudentsData.get(i).get(4));
										student.get(index).add(6,"1");
									}
									if(StudentsData.get(i).get(2).contains("project"))
									{
										student.get(index).add(7,StudentsData.get(i).get(4));
										student.get(index).add(8,"1");
									}
									
								}
							}
						}
						System.out.println("Student Name\tTest\tQuiz\tLabwork\tProject\tOverall Rating");
						for(int i=0;i<student.size();i++)
						{
							int Test = 0,Quiz = 0, Labwork = 0,Project = 0;
							if(Integer.valueOf(student.get(i).get(2)) != 0)
								Test = (assignmentCategory.get("Test")*Integer.valueOf(student.get(i).get(1)))/(Integer.valueOf(student.get(i).get(2))*100);
							if(Integer.valueOf(student.get(i).get(4)) != 0)
								Quiz = (assignmentCategory.get("Quiz")*Integer.valueOf(student.get(i).get(3)))/(Integer.valueOf(student.get(i).get(4))*100);
							if(Integer.valueOf(student.get(i).get(6)) != 0)
								Labwork = (assignmentCategory.get("Labwork")*Integer.valueOf(student.get(i).get(5)))/(Integer.valueOf(student.get(i).get(6))*100);
							if(Integer.valueOf(student.get(i).get(8)) != 0)
								Project = (assignmentCategory.get("Project")*Integer.valueOf(student.get(i).get(7)))/(Integer.valueOf(student.get(i).get(8))*100);
							System.out.println(student.get(i).get(0)+"\t"+Test+"\t"+Quiz+"\t"+Labwork+"\t"+Project+"\t"+(Test+Quiz+Labwork+Project));
						}
					break;
			}
		}
		
	}
}