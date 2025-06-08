package it.uniroma3.diadia.ambienti;

public enum Direzione {
	nord() {
		@Override
		public Direzione opposta() {
			return sud;
		}
	},
	
	est() {
		@Override
		public Direzione opposta() {
			return ovest;
		}
	},
	
	sud() {
		@Override
		public Direzione opposta() {
			return nord;
		}
	},
	
	ovest() {
		@Override
		public Direzione opposta() {
			return est;
		}
	};

	public abstract Direzione opposta();
}
