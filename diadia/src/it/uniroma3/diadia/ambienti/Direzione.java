package it.uniroma3.diadia.ambienti;

public enum Direzione {


	NORD(){
		
		@Override public Direzione opposta() {
			return SUD;
		}
		
	},
	
	SUD(){
		
		@Override public Direzione opposta() {
			return NORD;
		}
	},
	
	EST(){
		
		@Override public Direzione opposta(){
			return OVEST;
		}



	},
	
	OVEST(){
		
		@Override public Direzione opposta(){
			return EST;
		}
	};


	public static Direzione buildDirezione(String nome) {
		if(nome==null)
			return null;	
		switch (nome) {
		case "nord":
			return Direzione.NORD;
		case "sud":
			return Direzione.SUD;
		case "est":
			return Direzione.EST;
		case "ovest":
			return Direzione.OVEST;
		default:
			return null;
		}
	}
	public abstract Direzione opposta();

	

}
