package br.com.patiomile.utilitario;

public enum MensagensType {

	INSERIDO {
		public String toString() {
			return "Registro inserido com sucesso!";
		}
	},

	ATUALIZADO {
		public String toString() {
			return "Registro autalizado com sucesso!";
		}
	},

	EXCLUIDO {
		public String toString() {
			return "Registro excluido com sucesso!";
		}
	},

	ERROAOINSERIR {
		public String toString() {
			return "Erro ao inserir o registro!";
		}
	},

	ERROAOATUALIZAR {
		public String toString() {
			return "Erro ao atualizar o registro!";
		}
	},

	ERROAOEXCLUIR {
		public String toString() {
			return "Erro ao excluir o registro!";
		}
	},

	ERROAOPREENCHERLISTA {
		public String toString() {
			return "Erro ao preencher a lista!";
		}
	},

	IDIGUALZERO {
		public String toString() {
			return "Selecione um registro no grid para ser exclu�do!";
		}
	},

	CAMPONOMEUSUARIOVAZIO {
		public String toString() {
			return "O campo Login est� vazio!";
		}
	},

	CAMPOSENHAUSUARIOVAZIO {
		public String toString() {
			return "O campo senha est� vazio!";
		}
	},

	TITULOFRAMEEXCLUIR {
		public String toString() {
			return "Tem certeza que deseja excluir";
		}
	};

}
