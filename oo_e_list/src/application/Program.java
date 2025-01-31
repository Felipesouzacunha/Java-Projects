package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Funcionario;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Funcionario novoFuncionario;
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();

		System.out.print("Quantos funcionários deseja cadastrar? ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println("Funcionário #" + (i + 1) + ":");
			System.out.print("Id: ");
			int id = sc.nextInt();
			sc.nextLine();
			Funcionario verificado = verificar(funcionarios, id);
			if(verificado != null) {
				System.out.print("Esse id já existe, por favor tente outro: ");
				while(verificado != null) {
					id = sc.nextInt();
					verificado = verificar(funcionarios, id);
				}
				sc.nextLine();
			}
			System.out.print("Nome: ");
			String nome = sc.nextLine();
			System.out.print("Salário: ");
			double salario = sc.nextDouble();
			System.out.println();
			novoFuncionario = new Funcionario(id, nome, salario);
			funcionarios.add(novoFuncionario);
		}
		
		System.out.print("Digite o Id para aumento de salario: ");
		int id = sc.nextInt();
		Funcionario funcionarioVerificado = verificar(funcionarios, id);
		if(funcionarioVerificado != null) {
			System.out.print("Porcentagem para aumento: ");
			double porcentagem = sc.nextDouble();
			funcionarioVerificado.aumento(id, porcentagem);
		} else {
			System.out.println("Esse Id não é Válido");
		}
		
		System.out.println();
		System.out.println("Lista de funcionários: ");
		for(Funcionario funcionario : funcionarios) {
			System.out.println(funcionario);
		}
		
		sc.close();
	}
	
	public static Funcionario verificar(List<Funcionario> lista, int id) {
		Funcionario funcionarioVerificado = lista.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return funcionarioVerificado;
	}

}
