# Gerenciador de Playlists

Aplicação desktop em Java Swing para gerenciamento de playlists musicais, com persistência em banco de dados PostgreSQL.

---

## Pré-requisitos

- **Java JDK 11** ou superior
- **Apache Maven 3.6+** (ou NetBeans IDE com suporte a Maven/Ant)
- **PostgreSQL 13+** em execução local
- Driver JDBC do PostgreSQL (`postgresql-XX.X.X.jar`)

---

## Configuração do Banco de Dados

1. Crie o banco de dados no PostgreSQL:

```sql
CREATE DATABASE gerenciador_playlists;
```

2. Conecte-se ao banco e execute o dump de estrutura disponível em `backup.sql`:

```bash
psql -U postgres -d gerenciador_playlists -f backup.sql
```

3. Confirme que as credenciais em `Database.java` correspondem ao seu ambiente:

```java
String user  = "postgres";
String senha = "123";
String url   = "jdbc:postgresql://localhost:5432/gerenciador_playlists";
```

Altere os valores conforme necessário antes de compilar.

---

## Estrutura do Projeto

```
src/
└── com/udesc/
    ├── gerenciador/        # Ponto de entrada e conexão (MenuInicial, Database, Programa)
    ├── generos/            # CRUD de gêneros musicais
    ├── artistas/           # CRUD de artistas
    ├── musicas/            # CRUD de músicas
    └── playlists/          # CRUD de playlists e gerenciamento de músicas por playlist
```

---

## Compilação

### Via NetBeans IDE

1. Abra o projeto no NetBeans (**File → Open Project**).
2. Adicione o driver JDBC do PostgreSQL às dependências do projeto:
   - Clique com o botão direito em **Libraries → Add JAR/Folder** e selecione o `.jar` do driver.
3. Clique em **Clean and Build** (`Shift+F11`).

### Via linha de comando (Maven)

```bash
mvn clean package
```

O `.jar` executável será gerado em `target/`.

### Via linha de comando (javac manual)

```bash
# A partir da raiz do projeto, com o driver no classpath
javac -cp ".;postgresql-42.x.x.jar" -d out/ $(find src -name "*.java")
```

---

## Execução

### Via NetBeans

Clique em **Run Project** (`F6`). O ponto de entrada é `MenuInicial.main()`.

### Via linha de comando

```bash
java -cp ".;out/;postgresql-42.x.x.jar" com.udesc.gerenciador.MenuInicial
```

> No Linux/macOS substitua `;` por `:` no classpath.

### Via JAR gerado pelo Maven

```bash
java -jar target/gerenciador-playlists.jar
```

---

## Navegação na Aplicação

Ao iniciar, o **Menu Principal** apresenta quatro opções:

| Botão     | Função                                                |
|---        |---                                                    |
| Músicas   | Cadastro completo de músicas                          |
| Playlists | Cadastro de playlists e gerenciamento de suas músicas |
| Artistas  | Cadastro de artistas                                  |
| Gêneros   | Cadastro de gêneros musicais                          |

Dentro de **Playlists**, selecione uma playlist e clique em **Ver Músicas** para adicionar ou remover músicas da playlist.
