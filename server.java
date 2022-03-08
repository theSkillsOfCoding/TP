import java.net.*;
import java.io.*;
public class server {
    
    public static void main(String argv[]){
    int j = 0;    
    int res = 0 ; 
    int port = 2222;    
    
try {
ServerSocket serversocket = new ServerSocket(port); // positionne de socket d'ecoute
System.out.println("en attente des clients");      // mettre le serveur en attente de connexion avec client
Socket socket = serversocket.accept();  
ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());   // recuperer les flux objets pour communiquer avec client
ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
int[] tab = (int[])input.readObject();  //attente du tableau venant de la part du client 
while(j!= tab.length )
{System.out.println(tab[j]+" ");
j = j + 1;}
System.out.println("\n");
output.writeObject(doublon(tab , res));
System.out.println("the client adress : "+socket.getInetAddress()+ " : " +socket.getPort()); // les coordonnees du client 
System.out.println("my adresse :  "+socket.getLocalAddress()+ " : " +socket.getLocalPort()); // affichage du coordonnees
output.writeObject("Done"); // l'envoi 
}
catch(Exception e){

    System.err.println("Error :"+e);
}
}
static int doublon(int tab[] ,int res){       // fonction du recherche d'un element dans un tableau
    for(int i = 0 ; i<tab.length ; i++){
        for ( int j = i+1 ; j < tab.length-1 ; j++){
            if(tab[i]==tab[j])
                {res = 1 ;} 
            else {res = 0; }
        }
    }
    return res ; }}
