package com.theironyard;

/**
 * For this exercise you will write a simple main() method that prints out the
 * following text:
 *
 * 1
 * 2 2
 * 4 4 4 4
 * 5 5
 * 6 6 6 6 6 6
 *
 * Note the following facts:
 *
 * - 3 is not output at all
 * - 5 is only output twice
 * - You are required use nested for loops (not while loops)
 * - You will need to use both the "break" and continue "keywords"
 * - Each number is followed by a space. EG: 2_2_, not 2_2.
 *
 * The test is picky about formatting so make sure you get it right. Ask
 * questions if something is unclear.
 *
 */
public class Main {

    public static void main(String[] args) {

        /* Output the following text:
            1
            2 2
            4 4 4 4
            5 5
            6 6 6 6 6 6
         */
        // todo: output the expected text
        for(int i = 1; i <= 6; i++){
            String out ="";
            if(i == 3){
                continue;
            }
            for(int indx  = 1; indx <= i; indx++){
                out += i + " ";
                //does not work
                //out += " " + i;
                if(i == 5){
                    if(indx == 2){
                        break;
                    }
                }
            }
            System.out.println(out);
        }


    }

}
