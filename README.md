Setting up RESTful web services on GAE with Maven, JSR311 (Jersey) and Objectify.
=============================
Sorgenti del talk presentato al GDG DevFest 2013 @ Roma - http://devfest.gdg.io/
-----------------------------
La realizzazione di applicazioni web moderne è composta da più attori: persistenza, API RESTful(json/xml) e client(Web/Mobile/Standalone).
- Per quanto riguarda la persistenza normalmente, in ambito relazionale, si cade sul classicone JPA, per ovvi motivi. In ambiente Google App Engine, in particolare utilizzando il Datastore, si è fatto strada Objectify il quale ha dimostrato di essere la valida alternativa a JPA. Sbilanciandoci è il componente di riferimento per quanto riguarda la persistenza sul Datastore.
- In merito alle API RESTful, Java mette a disposizione un'apposita specifica, la JSR311, che permette di descrivere le nostre API. La specifica ha molte implementazioni: in questa sede andremo ad utilizzare quella che, in gergo, si chiama RI, Reference Implementation: Jersey.
- Per quanto riguarda lo sviluppo di client non scenderemo nel dettaglio: avendo realizzato API RESTful che "parlano" in JSON/XML, è possibile utilizzarle da qualsiasi linguaggio e/o piattaforma disponibile!
- Il progetto sarà strutturato utilizzando Maven che ci garantisce un'ottima gestione delle dipendenze: è sempre complicato usare i giusti JAR e, guardando alla crescita esponenziale della nostra startup :P, garantisce una migliore gestione dei progetti.

Ecco i tre sani principi

*It should be modular: “Do one thing, and do it well.”*

*It should be cooperative: "It takes a village.”*

*It should be composable: “It should be ready for anything.”*

che ci auspichiamo di rispettare!
