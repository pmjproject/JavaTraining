public class Star 
{
public static void main(String[] args) 
{
int i, j, k;
for(i=1;i<=10;i++)
{
for(j=i;j<10;j++)
{
System.out.print(" ");
}
for(k=1;k<(i*2);k++)
{
System.out.print("*");
}
System.out.println();
}
for(i=9;i>=1;i--)
{
for(j=10;j>i;j--)
{
System.out.print(" ");
}
for(k=1;k<(i*2);k++)
{
System.out.print("*");
}
System.out.println();
}
}
}