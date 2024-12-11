# Utiliser une image de base avec Tomcat
FROM tomcat:10.0

# Copier le fichier WAR dans le répertoire webapps de Tomcat
COPY target/assurance.war /usr/local/tomcat/webapps/

# Exposer le port 8080 pour l'accès à Tomcat
EXPOSE 8080

# Démarrer Tomcat
CMD ["catalina.sh", "run", "-verbose:class"]
