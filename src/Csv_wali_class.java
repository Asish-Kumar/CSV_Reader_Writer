import java.io.*;
import java.util.Vector;

public class Csv_wali_class {
    public static void main(String arg[]) throws IOException {
        //readFromAnyFile("active_hours.csv");
        // sabse pehle download the file
        // uske baad call chaneCharAt
        // last mein upload data
        Vector<String> data = changeCharAt();
        File fle = new File("D:\\active_hours.csv");
        fle.delete();
        writeToAnyFile(data,"active_hours.csv");
    }

    private static Vector<String> readFromAnyFile(String sourceFileNameWExt){
        //File dir = getFilesDir();
        String dir = "D:\\";
        File file = new File(dir, sourceFileNameWExt);
        String readData = "";
        Vector<String> data = new Vector<String>(0);
        //File f = new File()
        try {
            // Handle Csv file properly ASAP!!!.
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = null;
            while((line = bufferedReader.readLine() ) != null ){
//                Log.d("status", line);
                readData += line;
                data.add(line);
                //System.out.println(line);
            }
            bufferedReader.close();

        } catch (IOException e){
            e.printStackTrace();
          }
        return data;
    }

    private static void writeToAnyFile(Vector<String> data, String localFileName) throws IOException {

        //  localFileName is with the file with extension which needs the content to be written on it.
        String dir = "D:\\";
        File file = new File(dir, localFileName);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        for(int i =0;i < 8; i++) {
            bufferedWriter.append(data.get(i)+"\n");
        }
        bufferedWriter.close();

    }

    private static Vector<String> changeCharAt(){
        //read a line from active_hours.csv
        //change a value in this line
        //write back to the file
        Vector<String> data = readFromAnyFile("active_hours.csv");
        //System.out.println(data);
        int k = 2;  // date*2
        int time_ = 4;
        Boolean True_ = true;
        try{Boolean kuch = data.get(0).isBlank();}
        catch(Exception e){
            True_ = false;
        }
        for(int i = 0;True_;){
            if(i==k){ // we found the row
                // now time will tel at which index we have to edit in i
                StringBuilder row  = new StringBuilder(data.get(i));
                System.out.println(row.charAt(time_));
                 int value = Integer.parseInt(""+row.charAt(time_));
                try{
                    row.setCharAt(time_,(Integer.toString( value+ 6).charAt(0)));
                    System.out.println("44444444444"+row.charAt(time_));
                }
                catch(Exception e){
                    row.setCharAt(time_,Integer.toString((value + 6)% 10).charAt(0));
                    row.setCharAt(time_,Integer.toString((value + 6)/ 10).charAt(0));
                }

                data.set(i, row.toString());

            }
            System.out.println(data.get(i));
            i++;
            try{Boolean kuch = data.get(i).isBlank();}
            catch(Exception e){
                True_ = false;
            }
        }
        StringBuilder myName = new StringBuilder("domanokz");
        myName.setCharAt(4, 'x');

        System.out.println(myName);
        return data;
    }

}
