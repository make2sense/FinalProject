package com.udacity.gradle.jokes;

import java.util.Random;

public class Joker {
    private String[] jokes = new String[6];

    public Joker() {
        // http://www.babycenter.com/0_20-silly-jokes-for-kids_10317809.bc
        jokes[0] = "After many years, a prisoner is finally released.\n" +
                "He runs around yelling, \"I'm free! I'm free!\"\n" +
                "A little kid walks up to him and says, \"So what? I'm 4.\"";
        jokes[1] = "Q: A man arrived in a small town on Friday. He stayed for two days and left on Friday. How is this possible?\n" +
                "A: His horse's name is Friday!";
        jokes[2] = "Q: Why was 6 afraid of 7?\n" +
                "A: Because 7, 8, 9.";
        jokes[3] = "Q: Why did the boy bring a ladder to school?\n" +
                "A: He wanted to go to high school.";
        jokes[4] = "Q: Why did the girl smear peanut butter on the road?\n" +
                "A: To go with the traffic jam!";


        jokes[5] = "Q: Did you hear about the race between the lettuce and the tomato? A: The lettuce was a \"head\" and the tomato was trying to \"ketchup\"! \n" +
                "\n" +
                "source: http://jokes4us.com/miscellaneousjokes/schooljokes/kidjokes.html";
    }

    //public String[] getJokes() {
      //  return jokes;
    //}

    public String generateJoke() {
        Random rm = new Random();
        return jokes[rm.nextInt(jokes.length)];
    }
}