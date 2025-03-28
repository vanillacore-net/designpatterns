# Design- und Architekturmuster

## Erzeugungsmuster (Creational Patterns)

| Muster | Beschreibung | Anwendungsszenarien |
|--------|--------------|---------------------|
| **Singleton** | Stellt sicher, dass eine Klasse nur eine Instanz hat und bietet einen globalen Zugriffspunkt auf diese Instanz. | Wenn genau ein Objekt benötigt wird, das systemweit verfügbar sein muss, z.B. für Datenbank-Verbindungen, Logger oder Konfigurationsmanager. |
| **Factory** | Definiert eine Schnittstelle zur Erstellung eines Objekts, überlässt aber den Unterklassen die Entscheidung, welche Klasse instanziiert werden soll. | Wenn ein System unabhängig von der Art der Erzeugung seiner Produkte sein soll oder wenn Produktfamilien austauschbar sein müssen. |
| **Abstract Factory** | Bietet eine Schnittstelle zur Erstellung von Familien verwandter oder abhängiger Objekte, ohne ihre konkreten Klassen zu spezifizieren. | Wenn ein System mit mehreren Produktfamilien arbeiten muss und diese Familien austauschbar sein sollen, z.B. bei verschiedenen UI-Toolkits oder Datenbankzugriffen. |
| **Prototype** | Spezifiziert die Art von Objekten, die erstellt werden sollen, indem ein prototypisches Exemplar verwendet wird, das kopiert wird. | Wenn die Kosten für die Erstellung eines neuen Objekts hoch sind und strukturelle Ähnlichkeiten zwischen Objekten existieren, z.B. bei komplexen Grafikobjekten. |
| **Builder** | Trennt die Konstruktion eines komplexen Objekts von seiner Repräsentation, sodass derselbe Konstruktionsprozess verschiedene Repräsentationen erstellen kann. | Wenn ein Objekt schrittweise aufgebaut werden muss und verschiedene Darstellungen desselben Konstruktionsprozesses unterstützt werden sollen, z.B. bei der Erstellung von komplexen Dokumenten. |

## Strukturmuster (Structural Patterns)

| Muster | Beschreibung | Anwendungsszenarien |
|--------|--------------|---------------------|
| **Adapter** | Konvertiert die Schnittstelle einer Klasse in eine andere Schnittstelle, die der Client erwartet. | Wenn existierende Klassen verwendet werden sollen, deren Schnittstellen nicht kompatibel sind, z.B. bei der Integration von Drittanbieterbibliotheken. |
| **Bridge** | Entkoppelt eine Abstraktion von ihrer Implementierung, sodass beide unabhängig voneinander variieren können. | Wenn sowohl Abstraktionen als auch ihre Implementierungen erweitert werden sollen, ohne dass es zu Abhängigkeiten kommt, z.B. bei plattformübergreifenden Anwendungen. |
| **Composite** | Komponiert Objekte in Baumstrukturen, um Teil-Ganzes-Hierarchien zu repräsentieren. Ermöglicht Clients, einzelne Objekte und Kompositionen von Objekten einheitlich zu behandeln. | Wenn Klienten Objekte und ihre Kompositionen einheitlich behandeln sollen, z.B. bei grafischen Benutzerschnittstellen oder Dateisystemhierarchien. |
| **Facade** | Bietet eine einheitliche Schnittstelle zu einer Menge von Schnittstellen in einem Subsystem. Definiert eine Schnittstelle auf höherer Ebene, die das Subsystem einfacher zu verwenden macht. | Wenn eine einfache Schnittstelle zu einem komplexen Subsystem bereitgestellt werden soll, z.B. bei der Abstraktion von komplexen APIs oder Bibliotheken. |
| **Flyweight** | Verwendet Objektteilung, um eine große Anzahl feingranularer Objekte effizient zu unterstützen. | Wenn eine große Anzahl ähnlicher Objekte effizient verwaltet werden muss, z.B. bei Textverarbeitungssystemen oder Spielen mit vielen ähnlichen Grafikobjekten. |
| **Decorator** | Fügt einem Objekt dynamisch zusätzliche Verantwortlichkeiten hinzu. Bietet eine flexible Alternative zur Unterklassenbildung, um Funktionalität zu erweitern. | Wenn Funktionalitäten dynamisch und unabhängig voneinander zu Objekten hinzugefügt werden sollen, z.B. bei GUI-Komponenten oder I/O-Streams. |
| **Proxy** | Stellt einen Platzhalter für ein anderes Objekt dar, um den Zugriff darauf zu kontrollieren. | Wenn der Zugriff auf ein Objekt kontrolliert werden soll oder zusätzliche Funktionalität beim Zugriff hinzugefügt werden soll, z.B. bei Remote-Objekten, ressourcenintensiven Objekten oder Zugriffsschutz. |

## Verhaltensmuster (Behavioral Patterns)

| Muster | Beschreibung | Anwendungsszenarien |
|--------|--------------|---------------------|
| **Chain of Responsibility** | Ermöglicht, eine Anfrage entlang einer Kette von Handlern weiterzugeben, bis einer sie bearbeitet. | Wenn mehrere Objekte eine Anfrage behandeln können und der Handler nicht im Voraus bekannt ist, z.B. bei Event-Handling-Systemen oder Logging-Frameworks. |
| **Command** | Kapselt eine Anfrage als Objekt, wodurch es möglich wird, Clients mit verschiedenen Anfragen zu parametrisieren, Anfragen in eine Warteschlange zu stellen oder ein Protokoll der Anfragen zu führen. | Wenn Operationen rückgängig gemacht werden sollen oder wenn Operationen verzögert oder in eine Warteschlange gestellt werden sollen, z.B. bei GUI-Aktionen oder Transaktionsverarbeitung. |
| **Interpreter** | Definiert eine Repräsentation für die Grammatik einer Sprache und einen Interpreter, der Sätze in dieser Sprache interpretiert. | Wenn eine Sprache interpretiert werden muss und die Grammatik einfach ist, z.B. bei regulären Ausdrücken oder SQL-Parsern. |
| **Iterator** | Bietet einen Weg, um sequentiell auf die Elemente eines aggregierten Objekts zuzugreifen, ohne die zugrunde liegende Repräsentation offenzulegen. | Wenn auf die Elemente einer Sammlung zugegriffen werden soll, ohne die interne Struktur offenzulegen, z.B. bei der Durchquerung von komplexen Datenstrukturen. |
| **Mediator** | Definiert ein Objekt, das die Interaktion einer Menge von Objekten kapselt. Fördert lose Kopplung, indem es verhindert, dass Objekte explizit aufeinander verweisen. | Wenn die Kommunikation zwischen Objekten komplex ist und zentral verwaltet werden sollte, z.B. bei Dialog-Controllern oder Flugbuchungssystemen. |
| **Memento** | Erfasst und externalisiert den internen Zustand eines Objekts, ohne seine Kapselung zu verletzen, so dass das Objekt später in diesen Zustand zurückversetzt werden kann. | Wenn der Zustand eines Objekts gespeichert und später wiederhergestellt werden muss, z.B. bei Undo-Mechanismen oder Checkpoints. |
| **Observer** | Definiert eine 1:n-Abhängigkeit zwischen Objekten, sodass alle abhängigen Objekte benachrichtigt werden, wenn sich der Zustand eines beobachteten Objekts ändert. | Wenn Änderungen an einem Objekt an andere Objekte weitergegeben werden müssen, z.B. bei Event-Handling oder MVC-Architekturen. |
| **State** | Ermöglicht einem Objekt, sein Verhalten zu ändern, wenn sich sein interner Zustand ändert. Das Objekt erscheint, als würde es seine Klasse ändern. | Wenn das Verhalten eines Objekts von seinem Zustand abhängt und sich zur Laufzeit ändern muss, z.B. bei Workflow-Systemen oder Spielezuständen. |
| **Strategy** | Definiert eine Familie von Algorithmen, kapselt jeden und macht sie austauschbar. Ermöglicht, dass der Algorithmus unabhängig von den Clients variieren kann, die ihn verwenden. | Wenn verschiedene Varianten eines Algorithmus benötigt werden und diese zur Laufzeit ausgetauscht werden sollen, z.B. bei Sortier- oder Validierungsalgorithmen. |
| **Template Method** | Definiert das Skelett eines Algorithmus in einer Operation und delegiert einige Schritte an Unterklassen. Ermöglicht Unterklassen, bestimmte Schritte eines Algorithmus zu überschreiben, ohne die Struktur zu ändern. | Wenn ein Algorithmus eine feste Struktur hat, aber einige Schritte von Unterklassen spezialisiert werden müssen, z.B. bei Framework-Klassen oder Dokumentverarbeitung. |
| **Visitor** | Repräsentiert eine Operation, die auf den Elementen einer Objektstruktur ausgeführt werden soll. Ermöglicht, neue Operationen zu definieren, ohne die Klassen der Elemente zu ändern. | Wenn viele unterschiedliche Operationen auf Objekten einer Struktur ausgeführt werden müssen, ohne diese Klassen zu ändern, z.B. bei Compilerkomponenten oder Dokumentverarbeitung. |

## Architekturmuster (Architectural Patterns)

| Muster | Beschreibung | Anwendungsszenarien |
|--------|--------------|---------------------|
| **MVC (Model-View-Controller)** | Trennt eine Anwendung in drei Hauptkomponenten: Model (Daten), View (Darstellung) und Controller (Steuerung). | Wenn eine klare Trennung zwischen Datenmodell, Präsentation und Benutzerinteraktion gewünscht ist, z.B. bei Webanwendungen oder Desktop-GUIs. |
| **MVVM (Model-View-ViewModel)** | Erweitert MVC, indem es ein ViewModel als Abstraktionsschicht zwischen View und Model einfügt. | Wenn eine stärkere Bindung zwischen View und Datenmodell benötigt wird, besonders bei datenbindungsfähigen Frameworks, z.B. bei WPF, Angular oder Vue.js. |
| **Command-Processor** | Trennt die Anfrageverarbeitung von der Ausführung der Anfrage. | Wenn Anfragen verzögert, protokolliert oder rückgängig gemacht werden müssen, z.B. bei Transaktionssystemen oder Editoren. |
| **Pipes & Filters** | Strukturiert ein System als eine Sequenz von Datenverarbeitungsschritten, verbunden durch Datenströme. | Wenn Daten durch eine Reihe von unabhängigen Verarbeitungsschritten fließen müssen, z.B. bei ETL-Prozessen oder Bildverarbeitung. |
| **Broker** | Struktur mit entkoppelten Komponenten, die über Remote-Service-Aufrufe interagieren. | Wenn verteilte Systeme mit lose gekoppelten Komponenten entwickelt werden sollen, z.B. bei Nachrichtensystemen oder Cloud-Diensten. |
| **Microservices** | Strukturiert eine Anwendung als Sammlung kleiner, unabhängiger Dienste, die über APIs kommunizieren. | Wenn eine Anwendung in unabhängig entwickelbare, skalierbare und einsetzbare Komponenten aufgeteilt werden soll, z.B. bei großen Unternehmensanwendungen oder Cloud-nativen Anwendungen. |
| **Event-Driven** | Basiert auf der Produktion, Erkennung und Konsumption von Ereignissen, wobei Komponenten lose gekoppelt sind. | Wenn Systeme auf externe Ereignisse reagieren müssen oder asynchrone Kommunikation erforderlich ist, z.B. bei reaktiven Systemen oder IoT-Anwendungen. |


# Relevante Antipatterns und ihre Design Pattern-Lösungen

| Antipattern | Beschreibung | Typisches Auftreten | Lösungs-Design-Patterns |
|-------------|--------------|---------------------|---------------|
| **God Object / Blob** | Eine Klasse, die zu viele Verantwortlichkeiten übernimmt und zu groß wird. | In schnell wachsenden Systemen ohne klare Strukturierung. | **Strategy**, **Decorator**, **Command**, **Mediator**, **Facade** |
| **Tight Coupling** | Zu starke Abhängigkeiten zwischen Komponenten. | In monolithischen Anwendungen mit verflochtenem Code. | **Observer**, **Mediator**, **Facade**, **Adapter**, **Bridge** |
| **Duplicate Code** | Gleicher oder ähnlicher Code an verschiedenen Stellen. | Bei Copy-Paste-Programmierung oder fehlendem Wissen über Wiederverwendbarkeit. | **Template Method**, **Strategy**, **Factory Method** |
| **Feature Creep** | Ständiges Hinzufügen neuer Funktionen ohne konsistentes Design. | Bei anforderungsgetriebener Entwicklung ohne klare Architektur. | **Decorator**, **Command**, **Strategy**, **Composite** |
| **Inflexible Design** | System, das sich schwer an neue Anforderungen anpassen lässt. | In Systemen mit zu vielen Hardcodierungen oder starren Abhängigkeiten. | **Strategy**, **Factory Method**, **Abstract Factory**, **Bridge** |
| **Shotgun Surgery** | Eine Änderung erfordert viele kleine Modifikationen an verschiedenen Stellen. | Bei fehlender Kapselung und hoher Kopplung. | **Observer**, **Mediator**, **Facade** |
| **Singleton Abuse** | Übermäßige Verwendung des Singleton-Patterns für globalen Zustand. | Bei dem Versuch, einfachen Zugriff auf gemeinsame Ressourcen zu haben. | **Factory Method**, **Dependency Injection** |
| **Stovepipe System** | Komponenten, die schlecht integrierbar und wiederverwendbar sind. | Bei isolierter Entwicklung ohne Berücksichtigung der Gesamtarchitektur. | **Adapter**, **Facade**, **Mediator** |
| **Functional Decomposition** | Objektorientierter Code, der im prozeduralen Stil geschrieben ist. | Bei Entwicklern, die von prozeduralen zu OO-Sprachen wechseln. | **Command**, **Strategy**, **Template Method** |
| **Spaghetti Code** | Verworrener, schlecht strukturierter Code mit komplexen Abhängigkeiten. | Bei fehlender Planung oder über Zeit gewachsenem Code ohne Refactoring. | **MVC**, **Strategy**, **Template Method** |
| **Base Class Dependency** | Unterklassen sind zu stark von der Implementierung der Basisklasse abhängig. | In tief verschachtelten Vererbungshierarchien. | **Bridge**, **Strategy**, **Decorator** |
| **Call Super** | Unterklassen müssen immer Methoden der Oberklasse aufrufen. | In komplexen Vererbungshierarchien ohne klares Konzept. | **Template Method**, **Decorator** |
| **Interface Bloat** | Übermäßig große Interfaces mit zu vielen Methoden. | Bei dem Versuch, zu generische Komponenten zu bauen. | **Adapter**, **Facade**, **Composite** |
| **Sequential Coupling** | Methoden müssen in einer bestimmten Reihenfolge aufgerufen werden. | Bei komplexen Initialisierungsabläufen. | **Builder**, **Template Method**, **State** |
| **Circular Dependencies** | Komponenten, die gegenseitig voneinander abhängen. | Bei unklaren Verantwortlichkeiten und mangelnder Modularisierung. | **Mediator**, **Observer**, **Facade** |

# Ressourcen

- [Refactoring Guru](https://refactoring.guru/design-patterns)
- [SourceMaking](https://sourcemaking.com/design_patterns)
- [Wikipedia](https://de.wikipedia.org/wiki/Entwurfsmuster_(Softwareentwicklung))

