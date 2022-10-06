package tema_fin;
import java.util.ArrayList;
import java.util.Scanner;
public class Ttema3 {
	public static void main(String[] args) {
		try (Scanner read = new Scanner(System.in)) {
			ArrayList <Planete> lista = new ArrayList<Planete>();
			ArrayList<Planete> itinerariu = new ArrayList<Planete>();
			int i,j;
			String op; 
			do { 
				System.out.println(
						"a. Adaugare planeta\n"
						+"b. Eliminare planeta\n"
						+"c. Introducere itinerariu\n"
						+"d. Afisarea in consola a timpului total necesar parcurgerii intregului itinerariu curent\n"
						+"e. Iesire program\n");
				op=read.nextLine();
				System.out.println();
				if(op=="")
				{
					op=read.nextLine();
				}
				switch(op)
				{
				case "a": 
					{
						try
							{
							System.out.println("Nume Planeta");
							String planeta= read.nextLine();
							System.out.println("Coordonata 1 in ani lumina");
							float x = read.nextFloat();
							System.out.println("Coordonata 2 in ani lumina");
							float y = read.nextFloat();
							System.out.println("Coordonata 3 in ani lumina");
							float z = read.nextFloat();
							Planete a = new Planete(planeta,x,y,z);
							lista.add(a);	
							}
						catch(Exception e)
							{
							 System.out.println(e);
							}
					}break;
				case "b": 
					{
						System.out.println("Introduceti Planeta ce trebuie stearsa: ");
						try {
							String pt=read.nextLine();
							pt=pt.trim();//spatiile de pana si dupa cuvant
							for(i=0;i<lista.size();i++)
							{ 
								if(lista.get(i).getPlaneta().equalsIgnoreCase(pt))
									{
										lista.remove(i);
									}
							}
						} catch(Exception d)
						{
							System.out.println(d);
						}
						
					}break;
				case "c":
					{
						System.out.println("Introduceti itinerariul");
						String itin = read.nextLine();
						char[] tab = new char[100];
						int a=0, b=0;
						boolean flag=false;
						tab=itin.toCharArray();
						itinerariu.clear();
						for(i=0; i<itin.length(); i++)
						{

							if(Character.isLetter(tab[i])==true)
								a++;
							if(Character.isLetter(tab[i])==false && a>0 )
								{
									for(b=0; b < lista.size(); b++)
						if(lista.get(b).getPlaneta().toLowerCase().equals(itin.substring(i-a, i).toLowerCase()))
											{
												itinerariu.add(lista.get(b));
												flag = true;
											}
									a=0;
								}
							if(i == (itin.length()-1) && a>0 )
								{
									for(b=0; b < lista.size(); b++)
							if(lista.get(b).getPlaneta().toLowerCase().equals(itin.substring(i-a+1, i+1).toLowerCase()))
										{
											itinerariu.add(lista.get(b));
											flag = true;
										}
									a=0;
								}
						}
						if(flag==true)
							System.out.println("Itinerariu a fost suprascris ! "
						+ itinerariu);
						/*???*/
					}break;
				case "d":
					{	for(i=0; i< lista.size(); i++)
							System.out.println(lista.get(i).toString());
						double dist=0,distTotal=0,distKM=0,aux=365.25*24*3600,vl=299792458;
					for(i=0; i < itinerariu.size()-1; i++)
					{
						dist = Math.sqrt((itinerariu.get(i+1).getX()-itinerariu.get(i).getX())*(itinerariu.get(i+1).getX()-itinerariu.get(i).getX())+
							 (itinerariu.get(i+1).getY()-itinerariu.get(i).getY())*(itinerariu.get(i+1).getY()-itinerariu.get(i).getY())+
							 (itinerariu.get(i+1).getZ()-itinerariu.get(i).getZ())*(itinerariu.get(i+1).getZ()-itinerariu.get(i).getZ()));

						distTotal = distTotal + dist;}
					
						distKM=(aux*vl*distTotal*3.6)/40000;
					System.out.println("Durata totala traseului este: " + distKM);
						System.out.println("Distanta totala este: " + distTotal);
						for(i=0;i<itinerariu.size();i++)
						{
							for(j=i+1;j<itinerariu.size();j++)
							{
								dist=Math.sqrt(Math.pow(Math.abs(itinerariu.get(j).getX() - itinerariu.get(i).getX()),2) + Math.pow(Math.abs(itinerariu.get(j).getY() - itinerariu.get(i).getY()),2) + Math.pow(Math.abs(itinerariu.get(j).getZ() - itinerariu.get(i).getZ()),2));
								dist=(dist*365.25*24*1.07*Math.pow(10, 9));
								System.out.print(itinerariu.get(i).planeta+ "->");
								System.out.print(itinerariu.get(j).planeta+ "=");
								System.out.print(dist/3.26);
								System.out.println();
								
							}
						}

					}break;
				case "e":
					{
					 System.out.println("Iesire din program!");
					 return;
					}
				default: 
					
						System.out.println("Nu s-a introdus nici o optiune valida!");
				}
					
			}while(true);
		}
	}
}
		
