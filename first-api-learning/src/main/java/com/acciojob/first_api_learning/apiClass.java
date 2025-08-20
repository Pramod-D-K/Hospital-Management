package com.acciojob.first_api_learning;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v2")
public class apiClass {

    @GetMapping("getWeatherInfo")

    public String getWeatherinformation(){
        return "Hi, the temp is 21 degree and wind speed is 20km/hour "+
                " humidity is  30% and feels good ";
    }
    @GetMapping("/getHelloWorld")
    public String getingHelloworld(){
        return "\"Hello World\" ";
    }

    @GetMapping("/sum")
    public String calculateSum(@RequestParam("no1")Integer num1,@RequestParam("no2")Integer num2){
        long total = num1+num2;
        return "The sum of "+num1 + " and "+num2+ " is "+total;
    }
    @GetMapping("/intsum")
    public int intsum(@RequestParam("no1")int num1, @RequestParam("no2") int num2){
        return num1+num2;
    }

}
