Algoritmo "Viagens"
// Disciplina   : [Linguagem e L�gica de Programa��o]
// Professor   : Antonio Carlos Nicolodi 
// Descri��o   : Aqui voc� descreve o que o programa faz! (fun��o)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 24/07/2023
Var
   clientes: vetor[1..10]de caracter
   destinos: vetor[1..10] de caracter
   cadClientes, cadDestinos :caracter
   opcao , i:inteiro

Inicio
// Se��o de Comandos, procedimento, fun��es, operadores, etc...
repita
        escreval ("MENU")
        escreval ("1. Cadastrar cliente")
        escreval ("2. Cadastrar destino")
        escreval ("3. Consultar clientes")
        escreval ("4. Consultar destinos")
        escreval ("5. Sair")
        
        escreva ("Escolha uma op��o:")
        leia (opcao)
        
        escolha (opcao)
        caso 1
             para i de 1 ate 1 faca
             escreval ("Digite um nome: ")
             leia (clientes[i])
             fimpara
            //Eu queria fazer algo parecido com o push do js para armazenar
            //varios clientes e destinos sem precisar do la�o
            //porem nao consegui entao foi com um cliente e um destino s�
        caso 2
             para i de 1 ate 1 faca
             escreval ("Digite um destino: ")
             leia (destinos[i])
             fimpara
             
        caso 3
             para i de 1 ate 1 faca
             escreval (clientes[i])
             fimpara
             
        caso 4
             para i de 1 ate 1 faca
             escreval (destinos[i])
             fimpara
             
        caso 5
             escreval("saindo")

        fimescolha
 ate opcao=5
Fimalgoritmo