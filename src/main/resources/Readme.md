# ORGANIZER-NEWS

### By MANISHIMWE BENEDICTE

This App is made for company or instution to share information where the employees are listed with specified department and the badge number .and the general information are entered by every employees how has the key to enter in the sysytem and this person is able to dlete the information once wished.
## Getting Started

* Git clone. //https://github.com/mybene/Organisational-News-Portal
* gradle build
* create the postgres database


### Installing
list of databases and table names:
```
Production Database: media
Development Database: media_test
Table Names:departments,users,news.
CREATE TABLE news (id serial PRIMARY KEY,title,content);
CREATE TABLE departments(id serial PRIMARY KEY, dname VARCHAR, slogonVARCHAR ,membersVARCHAR , deptidVARCHAR );
CREATE TABLE users(id erial PRIMARY KEY,name VARCHAR, position VARCHAR ,dept VARCHAR , badgeidVARCHAR ) ;
```

## Built With

*  Spark
* Java
* Postgress Database(many-to-many relationship)


## References
* java ,canvas Moringa school


## License

Copyright (c) 2019 Manishimwe Benedicte

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.




