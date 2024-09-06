package DemoProject.DemoProject;



import DemoProject.DemoProject.files.payload;
import io.restassured.path.json.JsonPath;
import org.springframework.util.Assert;


public class SumValidation {


	public void sumOfCourses()
	{
		int sum = 0;
		JsonPath js=new JsonPath(payload.CoursePrice());
		int count=	js.getInt("courses.size()");
		for(int i=0;i<count;i++)
		{
			int price=js.getInt("courses["+i+"].price");
			int copies=js.getInt("courses["+i+"].copies");
			int amount = price * copies;
			System.out.println(amount);
			sum = sum + amount;
			
		}
		System.out.println(sum);
		int purchaseAmount =js.getInt("dashboard.purchaseAmount");
		//Assert.assertEquals(sum, purchaseAmount);
		Assert.isTrue(sum == purchaseAmount, "The sum of the courses is not equal to the purchase amount");

		
	}
}
