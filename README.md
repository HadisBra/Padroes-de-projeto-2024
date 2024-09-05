# Padroes-de-projeto-2024

Guilherme Alexandre Pereira Lima

Atividade 3

Como NÃO implementar uma solução para o retorno de boletos


No vídeo foi explicado porque tal solução inadequada e preguiçosa viola tais princípios. Considere que você possui uma solução como esta implementada e que precisa então resolver tais problemas. Como a violação dos princípios SRP, OCP, LSP e ISP pode ser evitada? Cite o que precisa ser feito para corrigir a violação de cada um destes princípios.

1. SRP (Single Responsibility Principle - Princípio da Responsabilidade Única)
Solução.
Divida a classe em várias classes menores, onde cada uma tenha uma única responsabilidade.
Por exemplo, você pode ter uma classe para processar o retorno do boleto, outra para validar o formato de arquivo, e uma terceira para extrair e interpretar dados específicos do boleto.
Isso melhora a coesão e garante que cada classe tenha uma responsabilidade bem definida, tornando o código mais modular e fácil de manter.

2. OCP (Open/Closed Principle - Princípio Aberto/Fechado)
Solução:
Utilize o padrão Strategy para permitir que novos tipos de boletos sejam integrados sem modificar a classe principal.
Crie uma interface ou classe abstrata, como BoletoStrategy, que defina os métodos que todos os tipos de boletos devem implementar (ex:processarRetorno()).

Cada tipo de boleto (ex: BoletoBancoA, BoletoBancoB) deve ser uma classe separada que implementa essa interface.
Dessa forma, se um novo tipo de boleto precisar ser adicionado, basta criar uma nova classe que implemente a interface, sem modificar a estrutura existente.

3. LSP (Liskov Substitution Principle - Princípio da Substituição de Liskov)

Solução:
Garanta que todas as subclasses possam ser substituídas sem quebrar o comportamento esperado.
Evite usar condicionais (como if-else ou switch-case) baseadas no tipo de boleto para tomar decisões. Em vez disso, use polimorfismo — defina comportamentos genéricos na interface ou superclasse e permita que as subclasses implementem seus detalhes específicos.
Isso significa que, ao utilizar qualquer implementação da interface BoletoStrategy, o código não precisará se preocupar com o tipo de boleto, pois cada implementação cuidará de seu próprio comportamento.

4. ISP (Interface Segregation Principle - Princípio da Segregação de Interfaces)
Solução:
Dívida interfaces grandes em interfaces menores e mais específicas.
Crie interfaces segregadas para cada tipo de responsabilidade. Por exemplo, se houver métodos relacionados ao processamento de boletos e outros para validação de dados, crie interfaces específicas para essas responsabilidades, como ValidadorDeBoleto e ProcessadorDeBoleto. Cada classe implementa apenas a interface (ou interfaces) que faz sentido para ela, evitando a dependência de métodos que não são necessários para todas as classes.

