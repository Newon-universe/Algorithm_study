8958. OX퀴즈

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int score = 0;
        int acc = 0;
        boolean seq = false;
        
        for(int j=0; j<n; j++){
            String input = br.readLine();
            
            for(int i=0; i<input.length(); i++){
                if(input.charAt(i) =='O' && seq){ 
                    acc++;
                    score += 1 + acc;
                } else if(input.charAt(i) =='O'){
                    score += 1;
                    seq = true;
                } else {
                    seq = false;
                    acc = 0;
                }
            }
            System.out.println(score);
        }
       
    }
}
