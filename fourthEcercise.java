import java.util.Scanner;

class oddnumber exception{
    oddnumber(){
        super("odd number exception");
    }
    oddnumber(String msg){
        super(msg);
    }
}

class fourthexercise{
    public static void main(String[] args){
        int num;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any two numbers:");
        num = Integer.parseInt(sc.nextLine());

        try{
            if(num%2!=0)
                throw(new oddnumber());
            else
                System.out.println(num+"is a even number");
        }
        System.out.println("End of the program");
    }
}
