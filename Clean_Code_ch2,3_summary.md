# Clean Code ch.2,3

# Chapter 2. Meaningful Names

---

<aside>
🔥 variables, functions, arguments, classes, packages, source files, directories 등 우리는 많은 것에 이름을 붙여야 한다. 그렇기 때문에 이름을 잘 붙이는 것은 중요하다.
좋은 이름을 붙이는 몇 가지 simple rules를 알아보자.

</aside>

### Use Intention-Revealing Names

좋은 이름을 고르기 위해서는 시간이 들지만, 좋은 이름을 고르고 나면 많은 시간이 절약된다.

variable, function, class 등의 이름은 왜 존재하는지, 무엇을 하는지, 어떻게 사용되는지가 명확해야 한다.

- 나쁜 예
    
    ```cpp
    int d; // elapsed time in days
    ```
    
    → `d` 라는 이름만으로는 아무 정보도 알 수 없다.
    
- 좋은 예
    
    ```cpp
    int elapsedTimeInDays;
    int daysSinceCreation;
    int daysSinceModification;
    int fileAgeInDays;
    ```
    
    단위를 적어주자.
    

- 나쁜 예
    
    ```cpp
    public List<int[]> getThem() {
    	List<int[]> list1 = new ArrayList<int[]>();
    	for (int[] x : theList)
    		if (x[0] == 4)
    			list1.add(x);
    	return list1;
    }
    ```
    
    위의 코드는 단순하지만 implicity가 문제이다. `theList`, `x`, `x[0]`, `4`, `list1` 등 이름만으로는 무엇을 담고 있는지, 얼마나 중요한 지, 어디에 사용해야 하는지 알아채기 어렵다.
    
- 좋은 예
    
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
    
    코드가 훨씬 explicit 해졌다.
    
- 더 좋은 예 (Cell에 대한 간단한 class 작성하여 사용)
    
    ```cpp
    public List<Cell> getFlaggedCells() {
    	List<Cell> flaggedCells = new ArrayList<Cell>();
    	for (Cell cell : gameBoard)
    		if (cell.isFlagged()) // Cell 클래스의 .isFlagged 함수를 호출하여 사용
    			flaggedCells.add(cell);
    	return flaggedCells;
    }
    ```
    

### Avoid Disinformation

- 잘못 해석될 수 있는 축약형 사용 피하기
- `List` 와 같이 programmers에게 특별한 의미를 가지는 단어는 grouping할 때 변수명에 사용하지 않기
    
    `accountList` 보다는 `accountGroup`, `bunchOfAccounts`, `accounts` 가 낫다.
    
- 서로 비슷해 보이는 naming 피하기

### Make Meaningful Distinctions

- Number-series naming 주의 (a1, a2, .. aN) → intentional naming과 반대된다.
- Info, Data와 같은 단어는 정확한 개념 구분을 어렵게 만든다.
- variable name에는 `variable`이, table name에는 `table`이 포함되어서는 안된다.
- getActiveAccount(), getActiveAccounts(), getActiveAccountInfo() 와 같이 이름이 비슷한 함수는 서로를 구분하기 어렵다.
- 구별 불가능한 변수명을 짓지 말자. (`moneyAmount vs money` , `customerInfo vs customer` , `accountData vs account` , `theMessage vs message` 등)

### Use Pronounceable Names

발음할 수 없는 이름으로 지으면, 바보같이 소리내어 읽지 않고는 그것에 대해 토의할 수 없다. 발음할 수 있는 이름을 사용하자.

### User Searchable Names

- constant number는 되도록 새롭게 정의해서 사용한다. → 검색 가능 하도록!
- single-letter의 이름은 짧은 범위 내의 local variables로만 사용하도록 한다. → 검색하기 어려우므로
” *The length of a name should correspond to the size of its scope. ”*

### Avoid Encodings

- Hungarian Notation
    - 이름에 data type을 명시하는 코딩 규칙
    - 초기의 컴파일러는 data type을 체크해주지 않았기 때문에 프로그래머가 data type을 이름을 통해 기억할 필요가 있었다.
    - 하지만 요즘은 컴파일러가 data type을 체크해주므로, Hungarian Notation이나 다른 type encoding은 변수, 함수, 클래스의 이름이나 type을 변경하기 어렵게 만드는 장애물일 뿐이다. → type을 이름에 명시할 필요 없다.
- Member Prefixes
    - 멤버 변수에 접두어(m_xxx)를 붙일 필요가 없다.
- Interfaces and Implementation
    - interface 클래스와 implement 클래스를 구분하는 경우, interface의 이름을 꾸미지 않은 상태로 두고, implement 클래스의 이름을 꾸며준다.
    - 예시
        
        
        |  | Interface class | Implementation class |
        | --- | --- | --- |
        | 예시1 | ShapeFactory | ShapeFactoryImp |
        | 예시2 | ShapeFactory | CShapeFactory |

### Avoid Mental Mapping

- 독자가 머릿속으로 변수명을 이미 알고 있는 단어로 바꾸게 할 만한 변수명을 사용하지 마라.
- loop 외에는 i, j, k와 같은 single-letter의 변수명을 사용하지 말자.
- *“The professional programmer understands that **clarity is king**.”*

### Class Names

- Noun or Noun phrase 사용
- 좋은 예시: `Customer`, `WikiPage`, `Account`, `AddressParser`
- 나쁜 예시: `Manager`, `Processor`, `Data`, `Info` 를 포함한 이름
- Verb 여서는 안된다.

### Method Names

- Verb or Verb phrase 사용
- 좋은 예시: `postPayment`, `deletePage`, `save`
- Accessors: `get`으로 시작
- Mutators: `set`으로 시작
- Predicates: `is`로 시작
- Constructor를 overload 하는 경우 매개변수에 대한 설명을 담은 이름을 가진 static factory method를 사용한다.
    
    ```cpp
    Complex fulcrumPoint = Complex.FromRealNumber(23.0);
    // 위의 것이 아래 것보다 일반적으로 좋다.
    Complex fulcrumPoint = new Complex(23.0);
    ```
    
    Contructor를 private으로 선언하여 사용 시 필수적으로 사용하도록 한다.
    

### Don’t Be Cute

- 자신의 문화에서만 사용되는 joke를 naming에 이용하지 마라.

### Pick One Word per Concept

- 하나의 추상적 개념에는 하나의 단어만 골라서 쭉 사용하라.
    - Example
        - 모든 클래스에서 같은 기능을 하는 method에 대해 fetch, retrieve, get 중 하나만

### Add Meaningful Context

- 적절한 이름의 클래스, 함수, 네임스페이스를 활용하여 context에 맞게 이름들을 배치하라.
- Example
    - 수정 전
        
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
        
    - 수정 후 (명확한 context 제공)
        
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
        

### Don’t Add Gratuitous Context

- 이름이 명확하기만 하면 일반적으로 긴 이름보다 짧은 이름이 더 좋다. 필요 이상으로 이름에 context를 붙이지 말라.

# Chapter 3. Functions

---

<aside>
💡 function은 어떤 프로그램이든 사용된다. function을 잘 작성하는 것이 중요하다.

</aside>

### Small!

function의 규칙은 첫 번째로 function은 작아야 한다는 것이며, 두 번째도 작아야 한다는 것이다.

- 나쁜 예
    
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
    
- 좋은 예
    
    ```java
    public static String renderPageWithSetupsAndTeardowns(
    		PageData pageData, boolean isSuite) throws Exception {
    		if (isTestPage(pageData))
    				includeSetupAndTeardownPages(pageData, isSuite);
    		return pageData.getHtml();
    }
    ```
    

- Blocks and Indenting
    
    if, else, while 등의 구문에 들어가는 블록은 한 줄이어야 한다. → function call 하는 한 줄!
    
    function을 작게 만들어주면서, 독자로 하여금 해당 블록에서 일어나는 일을 파악하기 쉽도록 한다.
    
    function의 indent level(들여쓰기 정도)은 1, 2단 이하로 유지하는 것이 좋다.
    

### Do One Thing

하나의 function은 한 가지 일만을 수행하도록 만든다.

> ***“ FUNCTIONS SHOULD DO ONE THING. THEY SHOULD DO IT WELL. THEY SHOULD DO IT ONLY. ”***
> 

- Sections within Functions
    
    한 function이 여러 개의 섹션으로 나뉠 수 있는 경우, 그 function은 한 가지일만을 수행하는 것이 아니다.
    

### One Level of Abstraction per Function

function이 한 가지 일만을 하게 하려면 function 내에 구문들이 모두 같은 수준으로 abstraction 되어야 한다. 구문 마다 abstraction 수준이 다른 경우 독자로 하여금 특정 표현이 필수적인 개념인지 상세한 설명인지 알기 어렵게 한다.

- Reading Code from Top to Bottom: ***The Stepdown Rule***
    
    우리는 코드가 위에서 아래로 읽히기를 바란다. function들도 위에서 아래로 내려갈 수록 abstraction 수준이 하나씩 내려가도록 순서에 맞춰 작성하는 것이 좋다. 이를 ***The Stepdown Rule***이라고 부른다.
    

### Switch Statements

switch 구문은 항상 N개의 일을 하기 때문에 작기 만들기 어렵다.

polymorphism을 이용하여 switch 구문을 low-level 클래스(abstrac class)에 포함시켜 다시는 반복되지 않도록(한번만 작성되도록) 한다.

### Use Descriptive Names

function이 어떤 일을 하는지 function의 이름에서 명확하게 보여주는 것이 좋다.

### Function Arguments

function의 매개변수는 적으면 적을 수록 좋다.

매개변수는 독자로 하여금 코드를 이해하기 어렵게 만든다.

- Common Monadic Forms
    - boolean fileExists(”MyFile”)
    - InputStream fileOpen(”MyFile”)
    - void passwordAttemptFaliedNtimes(int attempts)
- Flag Arguments
    - flag 매개변수는 ugly하다. boolean 값을 매개변수로 넘겨주는 것은 비실용적이며, 한 번에 한 가지 이상의 일을 하는 function이라고 크게 외치는 것과 같다.
- Dyadic Function
    
    매개변수가 한 개인 monadic function 보다 이해하기 어렵다. 가능하면 monadic function으로 바꾸도록 핟나.
    
- Triads
    
    위험도 상승. 세 개의 매개변수를 갖는 function을 만드는 것을 결정하는 데에 있어 신중해야 한다.
    
- Argument Object
    
    많은 매개변수가 필요한 경우, 그 중 일부를 하나의 클래스로 묶을 수 있는지 확인해라.
    
- Argument Lists
    
    가변적인 수의 매개변수를 갖는 function도 있다.
    
    - e.g. `String.format`
- Verbs and Keywords
    - monadic function의 경우 function과 매개변수가 verb/noun의 pair를 이루어야 한다.
    - function 이름에 매개변수의 이름(키워드)를 추가하여 매개변수의 순서를 기억하지 않아도 되도록 할 수 있다.

### Have No Side Effects

function이 한 가지 일만을 수행하도록 하면 Side Effect를 막을 수 있다.

- Output Arguments
    
    function 내에서 state를 변경하고자 하는 경우 function이 속해 있는 object의 state를 변경하는 방법을 선택하는 것이 좋다.
    

### Command Query Separation

하나의 function이 object의 state를 변경하고 동시에 object에 대한 정보를 반환하도록 하지마라.

> “Do One Thing!”
> 

둘 다 하면 혼란을 야기한다.

### Prefer Exceptions to Returning Error Codes

Try/Catch 블록을 잘 사용하면 error를 처리하기 위한 코드를 일반 코드와 분리할 수 있다.

- Error Handling Is One Thing
    
    error 처리 역시 한 가지 일이다. 따라서 error를 처리하는 function은 오직 error만을 처리하도록 한다.
    

### Don’t Repeat Yourself

duplication(중복)은 코드 양을 늘리고 수정을 어렵게 만든다. 또한 누락으로 인한 error를 증가시킨다.

### Structured Programming

Dijkstra’s rules of structured programming 에 따르면, 모든 function과 function 내부에 있는 모든 block은 하나의 입구와 하나의 출구만을 가져야 한다.

- 함수는 return문이 하나여야 한다.
- 루프 안에서 break, continue를 사용해서는 안된다.
- goto는 never, ever 안됨

이것은 함수가 아주 클 때만 이점을 가져온다.

### How Do You Write Functions Like This?

소프트웨어를 작성하는 것은 다른 종류의 글쓰기와 같다.

논문이나 기사를 작성할 때, 먼저 생각을 정리한 다음 쓰면 잘 써지듯이, 프로그래밍도 첫 번째 초안은 정리가 잘 안될 수 있다. 끊임없이 코드를 다듬는 과정이 필요하다.