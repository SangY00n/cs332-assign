# Clean Code ch.2,3

# Chapter 2. Meaningful Names

---

<aside>
π₯ variables, functions, arguments, classes, packages, source files, directories λ± μ°λ¦¬λ λ§μ κ²μ μ΄λ¦μ λΆμ¬μΌ νλ€. κ·Έλ κΈ° λλ¬Έμ μ΄λ¦μ μ λΆμ΄λ κ²μ μ€μνλ€.
μ’μ μ΄λ¦μ λΆμ΄λ λͺ κ°μ§ simple rulesλ₯Ό μμλ³΄μ.

</aside>

### Use Intention-Revealing Names

---

μ’μ μ΄λ¦μ κ³ λ₯΄κΈ° μν΄μλ μκ°μ΄ λ€μ§λ§, μ’μ μ΄λ¦μ κ³ λ₯΄κ³  λλ©΄ λ§μ μκ°μ΄ μ μ½λλ€.

variable, function, class λ±μ μ΄λ¦μ μ μ‘΄μ¬νλμ§, λ¬΄μμ νλμ§, μ΄λ»κ² μ¬μ©λλμ§κ° λͺνν΄μΌ νλ€.

- λμ μ
    
    ```cpp
    int d; // elapsed time in days
    ```
    
    β `d` λΌλ μ΄λ¦λ§μΌλ‘λ μλ¬΄ μ λ³΄λ μ μ μλ€.
    
- μ’μ μ
    
    ```cpp
    int elapsedTimeInDays;
    int daysSinceCreation;
    int daysSinceModification;
    int fileAgeInDays;
    ```
    
    λ¨μλ₯Ό μ μ΄μ£Όμ.
    

- λμ μ
    
    ```cpp
    public List<int[]> getThem() {
    	List<int[]> list1 = new ArrayList<int[]>();
    	for (int[] x : theList)
    		if (x[0] == 4)
    			list1.add(x);
    	return list1;
    }
    ```
    
    μμ μ½λλ λ¨μνμ§λ§ implicityκ° λ¬Έμ μ΄λ€. `theList`, `x`, `x[0]`, `4`, `list1` λ± μ΄λ¦λ§μΌλ‘λ λ¬΄μμ λ΄κ³  μλμ§, μΌλ§λ μ€μν μ§, μ΄λμ μ¬μ©ν΄μΌ νλμ§ μμμ±κΈ° μ΄λ ΅λ€.
    
- μ’μ μ
    
    ```cpp
    public List<int[]> getFlaggedCells() {
        List<int[]> flaggedCells = new ArrayList<int[]>();
        for (int[] cell : gameBoard) {
            if (cell[STATUS_VALUE] == FLAGGED) {
                flaggedCells.add(cell);
            }
        }
        return flaggedCells;
    }
    ```
    
    μ½λκ° ν¨μ¬ explicit ν΄μ‘λ€.
    
- λ μ’μ μ (Cellμ λν κ°λ¨ν class μμ±νμ¬ μ¬μ©)
    
    ```cpp
    public List<Cell> getFlaggedCells() {
    	List<Cell> flaggedCells = new ArrayList<Cell>();
    	for (Cell cell : gameBoard)
    		if (cell.isFlagged()) // Cell ν΄λμ€μ .isFlagged ν¨μλ₯Ό νΈμΆνμ¬ μ¬μ©
    			flaggedCells.add(cell);
    	return flaggedCells;
    }
    ```
    

### Avoid Disinformation

---

- μλͺ» ν΄μλ  μ μλ μΆμ½ν μ¬μ© νΌνκΈ°
- `List` μ κ°μ΄ programmersμκ² νΉλ³ν μλ―Έλ₯Ό κ°μ§λ λ¨μ΄λ groupingν  λ λ³μλͺμ μ¬μ©νμ§ μκΈ°
    
    `accountList` λ³΄λ€λ `accountGroup`, `bunchOfAccounts`, `accounts` κ° λ«λ€.
    
- μλ‘ λΉμ·ν΄ λ³΄μ΄λ naming νΌνκΈ°

### Make Meaningful Distinctions

---

- Number-series naming μ£Όμ (a1, a2, .. aN) β intentional namingκ³Ό λ°λλλ€.
- Info, Dataμ κ°μ λ¨μ΄λ μ νν κ°λ κ΅¬λΆμ μ΄λ ΅κ² λ§λ λ€.
- variable nameμλ `variable`μ΄, table nameμλ `table`μ΄ ν¬ν¨λμ΄μλ μλλ€.
- getActiveAccount(), getActiveAccounts(), getActiveAccountInfo() μ κ°μ΄ μ΄λ¦μ΄ λΉμ·ν ν¨μλ μλ‘λ₯Ό κ΅¬λΆνκΈ° μ΄λ ΅λ€.
- κ΅¬λ³ λΆκ°λ₯ν λ³μλͺμ μ§μ§ λ§μ. (`moneyAmount vs money` , `customerInfo vs customer` , `accountData vs account` , `theMessage vs message` λ±)

### Use Pronounceable Names

---

λ°μν  μ μλ μ΄λ¦μΌλ‘ μ§μΌλ©΄, λ°λ³΄κ°μ΄ μλ¦¬λ΄μ΄ μ½μ§ μκ³ λ κ·Έκ²μ λν΄ ν μν  μ μλ€. λ°μν  μ μλ μ΄λ¦μ μ¬μ©νμ.

### User Searchable Names

---

- constant numberλ λλλ‘ μλ‘­κ² μ μν΄μ μ¬μ©νλ€. β κ²μ κ°λ₯ νλλ‘!
- single-letterμ μ΄λ¦μ μ§§μ λ²μ λ΄μ local variablesλ‘λ§ μ¬μ©νλλ‘ νλ€. β κ²μνκΈ° μ΄λ €μ°λ―λ‘
β *The length of a name should correspond to the size of its scope. β*

### Avoid Encodings

---

- Hungarian Notation
    - μ΄λ¦μ data typeμ λͺμνλ μ½λ© κ·μΉ
    - μ΄κΈ°μ μ»΄νμΌλ¬λ data typeμ μ²΄ν¬ν΄μ£Όμ§ μμκΈ° λλ¬Έμ νλ‘κ·Έλλ¨Έκ° data typeμ μ΄λ¦μ ν΅ν΄ κΈ°μ΅ν  νμκ° μμλ€.
    - νμ§λ§ μμ¦μ μ»΄νμΌλ¬κ° data typeμ μ²΄ν¬ν΄μ£Όλ―λ‘, Hungarian Notationμ΄λ λ€λ₯Έ type encodingμ λ³μ, ν¨μ, ν΄λμ€μ μ΄λ¦μ΄λ typeμ λ³κ²½νκΈ° μ΄λ ΅κ² λ§λλ μ₯μ λ¬ΌμΌ λΏμ΄λ€. β typeμ μ΄λ¦μ λͺμν  νμ μλ€.
- Member Prefixes
    - λ©€λ² λ³μμ μ λμ΄(m_xxx)λ₯Ό λΆμΌ νμκ° μλ€.
- Interfaces and Implementation
    - interface ν΄λμ€μ implement ν΄λμ€λ₯Ό κ΅¬λΆνλ κ²½μ°, interfaceμ μ΄λ¦μ κΎΈλ―Έμ§ μμ μνλ‘ λκ³ , implement ν΄λμ€μ μ΄λ¦μ κΎΈλ©°μ€λ€.
    - μμ
        
        
        |  | Interface class | Implementation class |
        | --- | --- | --- |
        | μμ1 | ShapeFactory | ShapeFactoryImp |
        | μμ2 | ShapeFactory | CShapeFactory |

### Avoid Mental Mapping

---

- λμκ° λ¨Έλ¦ΏμμΌλ‘ λ³μλͺμ μ΄λ―Έ μκ³  μλ λ¨μ΄λ‘ λ°κΎΈκ² ν  λ§ν λ³μλͺμ μ¬μ©νμ§ λ§λΌ.
- loop μΈμλ i, j, kμ κ°μ single-letterμ λ³μλͺμ μ¬μ©νμ§ λ§μ.
- *βThe professional programmer understands that **clarity is king**.β*

### Class Names

---

- Noun or Noun phrase μ¬μ©
- μ’μ μμ: `Customer`, `WikiPage`, `Account`, `AddressParser`
- λμ μμ: `Manager`, `Processor`, `Data`, `Info` λ₯Ό ν¬ν¨ν μ΄λ¦
- Verb μ¬μλ μλλ€.

### Method Names

---

- Verb or Verb phrase μ¬μ©
- μ’μ μμ: `postPayment`, `deletePage`, `save`
- Accessors: `get`μΌλ‘ μμ
- Mutators: `set`μΌλ‘ μμ
- Predicates: `is`λ‘ μμ
- Constructorλ₯Ό overload νλ κ²½μ° λ§€κ°λ³μμ λν μ€λͺμ λ΄μ μ΄λ¦μ κ°μ§ static factory methodλ₯Ό μ¬μ©νλ€.
    
    ```cpp
    Complex fulcrumPoint = Complex.FromRealNumber(23.0);
    // μμ κ²μ΄ μλ κ²λ³΄λ€ μΌλ°μ μΌλ‘ μ’λ€.
    Complex fulcrumPoint = new Complex(23.0);
    ```
    
    Contructorλ₯Ό privateμΌλ‘ μ μΈνμ¬ μ¬μ© μ νμμ μΌλ‘ μ¬μ©νλλ‘ νλ€.
    

### Donβt Be Cute

---

- μμ μ λ¬Ένμμλ§ μ¬μ©λλ jokeλ₯Ό namingμ μ΄μ©νμ§ λ§λΌ.

### Pick One Word per Concept

---

- νλμ μΆμμ  κ°λμλ νλμ λ¨μ΄λ§ κ³¨λΌμ μ­ μ¬μ©νλΌ.
    - Example
        - λͺ¨λ  ν΄λμ€μμ κ°μ κΈ°λ₯μ νλ methodμ λν΄ fetch, retrieve, get μ€ νλλ§

### Add Meaningful Context

---

- μ μ ν μ΄λ¦μ ν΄λμ€, ν¨μ, λ€μμ€νμ΄μ€λ₯Ό νμ©νμ¬ contextμ λ§κ² μ΄λ¦λ€μ λ°°μΉνλΌ.
- Example
    - μμ  μ 
        
        ```cpp
        private void printGuessStatistics(char candidate, int count) {
        		String number;
        		String verb;
        		String pluralModifier;
        		if (count == 0) {
        				number = "no";
        				verb = "are";
        				pluralModifier = "s";
        		} else if (count == 1) {
        				number = "1";
        				verb = "is";
        				pluralModifier = "";
        		} else {
        				number = Integer.toString(count);
        				verb = "are";
        				pluralModifier = "s";
        		}
        		String guessMessage = String.format(
        				"There %s %s %s%s", verb, number, candidate, pluralModifier
        		);
        		print(guessMessage);
        }
        ```
        
    - μμ  ν (λͺνν context μ κ³΅)
        
        ```cpp
        public class GuessStatisticsMessage {
        		private String number;
        		private String verb;
        		private String pluralModifier;
        		public String make(char candidate, int count) {
        				createPluralDependentMessageParts(count);
        				return String.format(
        						"There %s %s %s%s", 
        						verb, number, candidate, pluralModifier );
        		}
        		private void createPluralDependentMessageParts(int count) {
        				if (count == 0) {
        						thereAreNoLetters();
        				} else if (count == 1) {
        						thereIsOneLetter();
        				} else {
        						thereAreManyLetters(count);
        				}
        		}
        		private void thereAreManyLetters(int count) {
        				number = Integer.toString(count);
        				verb = "are";
        				pluralModifier = "s";
        		}
        		private void thereIsOneLetter() {
        				number = "1";
        				verb = "is";
        				pluralModifier = "";
        		}
        		private void thereAreNoLetters() {
        				number = "no";
        				verb = "are";
        				pluralModifier = "s";
        		}
        }
        ```
        

### Donβt Add Gratuitous Context

---

- μ΄λ¦μ΄ λͺννκΈ°λ§ νλ©΄ μΌλ°μ μΌλ‘ κΈ΄ μ΄λ¦λ³΄λ€ μ§§μ μ΄λ¦μ΄ λ μ’λ€. νμ μ΄μμΌλ‘ μ΄λ¦μ contextλ₯Ό λΆμ΄μ§ λ§λΌ.

# Chapter 3. Functions

---

<aside>
π‘ functionμ μ΄λ€ νλ‘κ·Έλ¨μ΄λ  μ¬μ©λλ€. functionμ μ μμ±νλ κ²μ΄ μ€μνλ€.

</aside>

### Small!

---

functionμ κ·μΉμ μ²« λ²μ§Έλ‘ functionμ μμμΌ νλ€λ κ²μ΄λ©°, λ λ²μ§Έλ μμμΌ νλ€λ κ²μ΄λ€.

- λμ μ
    
    ```java
    public static String renderPageWithSetupsAndTeardowns(
    		PageData pageData, boolean isSuite
    ) throws Exception {
    		boolean isTestPage = pageData.hasAttribute("Test");
    		if (isTestPage) {
    				WikiPage testPage = pageData.getWikiPage();
    				StringBuffer newPageContent = new StringBuffer();
    				includeSetupPages(testPage, newPageContent, isSuite);
    				newPageContent.append(pageData.getContent());
    				includeTeardownPages(testPage, newPageContent, isSuite);
    				pageData.setContent(newPageContent.toString());
    		}
    		return pageData.getHtml();
    }
    ```
    
- μ’μ μ
    
    ```java
    public static String renderPageWithSetupsAndTeardowns(
    		PageData pageData, boolean isSuite) throws Exception {
    		if (isTestPage(pageData))
    				includeSetupAndTeardownPages(pageData, isSuite);
    		return pageData.getHtml();
    }
    ```
    

- Blocks and Indenting
    
    if, else, while λ±μ κ΅¬λ¬Έμ λ€μ΄κ°λ λΈλ‘μ ν μ€μ΄μ΄μΌ νλ€. β function call νλ ν μ€!
    
    functionμ μκ² λ§λ€μ΄μ£Όλ©΄μ, λμλ‘ νμ¬κΈ ν΄λΉ λΈλ‘μμ μΌμ΄λλ μΌμ νμνκΈ° μ½λλ‘ νλ€.
    
    functionμ indent level(λ€μ¬μ°κΈ° μ λ)μ 1, 2λ¨ μ΄νλ‘ μ μ§νλ κ²μ΄ μ’λ€.
    

### Do One Thing

---

νλμ functionμ ν κ°μ§ μΌλ§μ μννλλ‘ λ§λ λ€.

> ***β FUNCTIONS SHOULD DO ONE THING. THEY SHOULD DO IT WELL. THEY SHOULD DO IT ONLY. β***
> 

- Sections within Functions
    
    ν functionμ΄ μ¬λ¬ κ°μ μΉμμΌλ‘ λλ  μ μλ κ²½μ°, κ·Έ functionμ ν κ°μ§μΌλ§μ μννλ κ²μ΄ μλλ€.
    

### One Level of Abstraction per Function

---

functionμ΄ ν κ°μ§ μΌλ§μ νκ² νλ €λ©΄ function λ΄μ κ΅¬λ¬Έλ€μ΄ λͺ¨λ κ°μ μμ€μΌλ‘ abstraction λμ΄μΌ νλ€. κ΅¬λ¬Έ λ§λ€ abstraction μμ€μ΄ λ€λ₯Έ κ²½μ° λμλ‘ νμ¬κΈ νΉμ  ννμ΄ νμμ μΈ κ°λμΈμ§ μμΈν μ€λͺμΈμ§ μκΈ° μ΄λ ΅κ² νλ€.

- Reading Code from Top to Bottom: ***The Stepdown Rule***
    
    μ°λ¦¬λ μ½λκ° μμμ μλλ‘ μ½νκΈ°λ₯Ό λ°λλ€. functionλ€λ μμμ μλλ‘ λ΄λ €κ° μλ‘ abstraction μμ€μ΄ νλμ© λ΄λ €κ°λλ‘ μμμ λ§μΆ° μμ±νλ κ²μ΄ μ’λ€. μ΄λ₯Ό ***The Stepdown Rule***μ΄λΌκ³  λΆλ₯Έλ€.
    

### Switch Statements

---

switch κ΅¬λ¬Έμ ν­μ Nκ°μ μΌμ νκΈ° λλ¬Έμ μκΈ° λ§λ€κΈ° μ΄λ ΅λ€.

polymorphismμ μ΄μ©νμ¬ switch κ΅¬λ¬Έμ low-level ν΄λμ€(abstrac class)μ ν¬ν¨μμΌ λ€μλ λ°λ³΅λμ§ μλλ‘(νλ²λ§ μμ±λλλ‘) νλ€.

### Use Descriptive Names

---

functionμ΄ μ΄λ€ μΌμ νλμ§ functionμ μ΄λ¦μμ λͺννκ² λ³΄μ¬μ£Όλ κ²μ΄ μ’λ€.

### Function Arguments

---

functionμ λ§€κ°λ³μλ μ μΌλ©΄ μ μ μλ‘ μ’λ€.

λ§€κ°λ³μλ λμλ‘ νμ¬κΈ μ½λλ₯Ό μ΄ν΄νκΈ° μ΄λ ΅κ² λ§λ λ€.

- Common Monadic Forms
    - boolean fileExists(βMyFileβ)
    - InputStream fileOpen(βMyFileβ)
    - void passwordAttemptFaliedNtimes(int attempts)
- Flag Arguments
    - flag λ§€κ°λ³μλ uglyνλ€. boolean κ°μ λ§€κ°λ³μλ‘ λκ²¨μ£Όλ κ²μ λΉμ€μ©μ μ΄λ©°, ν λ²μ ν κ°μ§ μ΄μμ μΌμ νλ functionμ΄λΌκ³  ν¬κ² μΈμΉλ κ²κ³Ό κ°λ€.
- Dyadic Function
    
    λ§€κ°λ³μκ° ν κ°μΈ monadic function λ³΄λ€ μ΄ν΄νκΈ° μ΄λ ΅λ€. κ°λ₯νλ©΄ monadic functionμΌλ‘ λ°κΎΈλλ‘ νλ.
    
- Triads
    
    μνλ μμΉ. μΈ κ°μ λ§€κ°λ³μλ₯Ό κ°λ functionμ λ§λλ κ²μ κ²°μ νλ λ°μ μμ΄ μ μ€ν΄μΌ νλ€.
    
- Argument Object
    
    λ§μ λ§€κ°λ³μκ° νμν κ²½μ°, κ·Έ μ€ μΌλΆλ₯Ό νλμ ν΄λμ€λ‘ λ¬Άμ μ μλμ§ νμΈν΄λΌ.
    
- Argument Lists
    
    κ°λ³μ μΈ μμ λ§€κ°λ³μλ₯Ό κ°λ functionλ μλ€.
    
    - e.g. `String.format`
- Verbs and Keywords
    - monadic functionμ κ²½μ° functionκ³Ό λ§€κ°λ³μκ° verb/nounμ pairλ₯Ό μ΄λ£¨μ΄μΌ νλ€.
    - function μ΄λ¦μ λ§€κ°λ³μμ μ΄λ¦(ν€μλ)λ₯Ό μΆκ°νμ¬ λ§€κ°λ³μμ μμλ₯Ό κΈ°μ΅νμ§ μμλ λλλ‘ ν  μ μλ€.

### Have No Side Effects

---

functionμ΄ ν κ°μ§ μΌλ§μ μννλλ‘ νλ©΄ Side Effectλ₯Ό λ§μ μ μλ€.

- Output Arguments
    
    function λ΄μμ stateλ₯Ό λ³κ²½νκ³ μ νλ κ²½μ° functionμ΄ μν΄ μλ objectμ stateλ₯Ό λ³κ²½νλ λ°©λ²μ μ ννλ κ²μ΄ μ’λ€.
    

### Command Query Separation

---

νλμ functionμ΄ objectμ stateλ₯Ό λ³κ²½νκ³  λμμ objectμ λν μ λ³΄λ₯Ό λ°ννλλ‘ νμ§λ§λΌ.

> βDo One Thing!β
> 

λ λ€ νλ©΄ νΌλμ μΌκΈ°νλ€.

### Prefer Exceptions to Returning Error Codes

---

Try/Catch λΈλ‘μ μ μ¬μ©νλ©΄ errorλ₯Ό μ²λ¦¬νκΈ° μν μ½λλ₯Ό μΌλ° μ½λμ λΆλ¦¬ν  μ μλ€.

- Error Handling Is One Thing
    
    error μ²λ¦¬ μ­μ ν κ°μ§ μΌμ΄λ€. λ°λΌμ errorλ₯Ό μ²λ¦¬νλ functionμ μ€μ§ errorλ§μ μ²λ¦¬νλλ‘ νλ€.
    

### Donβt Repeat Yourself

---

duplication(μ€λ³΅)μ μ½λ μμ λλ¦¬κ³  μμ μ μ΄λ ΅κ² λ§λ λ€. λν λλ½μΌλ‘ μΈν errorλ₯Ό μ¦κ°μν¨λ€.

### Structured Programming

---

Dijkstraβs rules of structured programming μ λ°λ₯΄λ©΄, λͺ¨λ  functionκ³Ό function λ΄λΆμ μλ λͺ¨λ  blockμ νλμ μκ΅¬μ νλμ μΆκ΅¬λ§μ κ°μ ΈμΌ νλ€.

- ν¨μλ returnλ¬Έμ΄ νλμ¬μΌ νλ€.
- λ£¨ν μμμ break, continueλ₯Ό μ¬μ©ν΄μλ μλλ€.
- gotoλ never, ever μλ¨

μ΄κ²μ ν¨μκ° μμ£Ό ν΄ λλ§ μ΄μ μ κ°μ Έμ¨λ€.

### How Do You Write Functions Like This?

---

μννΈμ¨μ΄λ₯Ό μμ±νλ κ²μ λ€λ₯Έ μ’λ₯μ κΈμ°κΈ°μ κ°λ€.

λΌλ¬Έμ΄λ κΈ°μ¬λ₯Ό μμ±ν  λ, λ¨Όμ  μκ°μ μ λ¦¬ν λ€μ μ°λ©΄ μ μ¨μ§λ―μ΄, νλ‘κ·Έλλ°λ μ²« λ²μ§Έ μ΄μμ μ λ¦¬κ° μ μλ  μ μλ€. λμμμ΄ μ½λλ₯Ό λ€λ¬λ κ³Όμ μ΄ νμνλ€.