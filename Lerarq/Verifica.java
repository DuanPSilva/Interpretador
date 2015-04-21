class Verifica{
	public static boolean vdd(double a,double b, String opr){
		int x=0;
		switch(opr){
			case(">="):{
				if(a>=b)
					x=1;break;
			}
			case("="):{
				if(a==b)
					x=1;break;
			}
			case("<="):{
				if(a<=b)
					x=1;break;
			}
			case(">"):{
				if(a>b)
					x=1;break;
			}
			case("<"):{
				if(a<b)
					x=1;break;
			}
			case("!"):{
				if(a!=b)
					x=1;break;
			}
		}
		return x==1;
	}
	public double operacao(double a, double b, String opr){
		switch(opr){
			case("+"):{
				a=a+b;	
				break;
			}
			case("-"):{
				a=a-b;
				break;
			}
			case("x"):{
				a=a*b;
				break;
			}
			case("/"):{
				a=a/b;
				break;
			}
			case("%"):{
				a=a%b;
				break;
			}
		}
		return a;
	}
}