# Hibernate-Examples
This Repo contains hibernate examples from scratch to expert.

We can download the hibernate jars from hibernate.org site

http://hibernate.org/

For the basic jars select the Hibernate ORM option and download.

This branch contains CRUD operations using hibernate.

Also changed in the hibernate-cfg.xml


//When public key retrieval fails add allowPublicKeyRetrieval=TRUE should be added
<property name="connection.url">jdbc:mysql://localhost:3306/vivek?allowPublicKeyRetrieval=TRUE&amp;serverTimezone=UTC</property>

//When there is a SSL error add useSSL = false
<property name="connection.url">jdbc:mysql://localhost:3306/vivek?useSSL=false&amp;serverTimezone=UTC</property>


check first few commits for right syntax
