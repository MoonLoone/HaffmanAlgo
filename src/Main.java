import transfer_system_elements.DataSource;

import java.util.Scanner;

//‘Oh, the sea’s full of life,’ he said. ‘Yes, it’s an old world,’ MacDunn smoked his cigar and looked worried. ‘Now, I’ve got something to tell you. The Fog Horn sounds like an animal, doesn’t it? A big lonely animal crying in the night. Calling out to the Deep, ‘I’m here, I’m here.’ Well, you have been here for three months, Johnny, so I’m going to tell you. Something comes to visit the lighthouse.’ ‘Do you mean the fish?’ ‘No, something else. First it happened three years ago. It usually happens about this time of the year. Let’s wait and watch.’ While they were waiting, MacDunn told some theories about the Fog Horn to Johnny. ‘One day a man walked along the cold shore. Then he stopped and said, «We need a voice to call across the water to the ships. I’ll make one like a voice of the fog. I’ll make a sound that’s so lonely that everybody listens to it. Everyone who hears it will start crying, and their hearts will become warmer.» I made up that story to explain why it keeps coming back to the lighthouse. The Fog Horn calls it, I think, and it comes…’

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DataSource dataSource = new DataSource(sc.nextLine());
    }
}