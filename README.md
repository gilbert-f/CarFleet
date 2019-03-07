# Team GADD CSS Project


Download from this link: https://dev.mysql.com/get/Downloads/MySQLInstaller/mysql-installer-web-community-8.0.13.0.msi

1. Accept License Agreement
2. Select **Server only** from the install list options and proceed with installation.
3. Select **Standalone MySQL Server / Classic MySQL Replication** from Group Replication.
4. Leave **Type and Networking** as is.
5. Use **Strong password encryption**.
6. Set up the root password.
7. Don't start the MySQL server at boot (up to you).
8. Finished.

Test the installation by running the *MySQL 8.0 Command Line Client*.

#### Running
To start the service, open a command prompt in *Adminstrator* mode and enter:
```
net start mysql80
```