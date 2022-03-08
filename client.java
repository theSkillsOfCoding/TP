import java.net.*;
import java.io.*;
public class client 
{
        
    public static void main(String argv[]){
    int i = 0;
    int port = 2222;    
    String adr = "localhost";
    
try {
Socket socket = new Socket(adr , port); // positionne de socket d'ecoute
ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());   // recuperer les flux objets pour communiquer avec client
ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
int[] tab = {1,2,3,4,5,6,7,7,9}; //attente du tableau venant de la part du client 
output.writeObject(tab);
int ch = (int) input.readObject(); // l'envoi 
System.out.println("the server adress : "+socket.getInetAddress()+ " : " +socket.getPort()); // les coordonnees du client 
System.out.println("my adresse :  "+socket.getLocalAddress()+ " : " +socket.getLocalPort()); // affichage du coordonnees
while(i != tab.length )
{System.out.println(tab[i]);
i = i + 1;}
System.out.println("\n");
if (ch==0){System.out.println("ce tableau ne contient pas des doublons ");}
else {System.out.println("ce tableau contient des doublons");}

}
catch(Exception e){

    System.err.println("Error :"+e);
}
}
}
