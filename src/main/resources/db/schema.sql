-- noinspection SqlNoDataSourceInspectionForFile

DROP TABLE IF EXISTS oauth_client_details;
CREATE TABLE oauth_client_details (
  client_id VARCHAR(255) PRIMARY KEY,
  resource_ids VARCHAR(255),
  client_secret VARCHAR(255),
  scope VARCHAR(255),
  authorized_grant_types VARCHAR(255),
  web_server_redirect_uri VARCHAR(255),
  authorities VARCHAR(255),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additional_information VARCHAR(4096),
  autoapprove VARCHAR(255)
);
DROP TABLE IF EXISTS oauth_client_token;
CREATE TABLE oauth_client_token (
  token_id VARCHAR(255),
  token VARBINARY,
  authentication_id VARCHAR(255) PRIMARY KEY,
  user_name VARCHAR(255),
  client_id VARCHAR(255)
);
DROP TABLE IF EXISTS oauth_access_token;
CREATE TABLE oauth_access_token (
  token_id VARCHAR(255),
  token VARBINARY,
  authentication_id VARCHAR(255) PRIMARY KEY,
  user_name VARCHAR(255),
  client_id VARCHAR(255),
  authentication VARBINARY,
  refresh_token VARCHAR(255)
);
DROP TABLE IF EXISTS oauth_refresh_token;
CREATE TABLE oauth_refresh_token (
  token_id VARCHAR(255),
  token VARBINARY,
  authentication VARBINARY
);
DROP TABLE IF EXISTS oauth_code;
CREATE TABLE oauth_code (
  code VARCHAR(255), authentication  VARBINARY
);
DROP TABLE IF EXISTS oauth_approvals;
CREATE TABLE oauth_approvals (
  userId VARCHAR(255),
  clientId VARCHAR(255),
  scope VARCHAR(255),
  status VARCHAR(10),
  expiresAt TIMESTAMP,
  lastModifiedAt TIMESTAMP
);
DROP TABLE IF EXISTS ClientDetails;
CREATE TABLE ClientDetails (
  appId VARCHAR(255) PRIMARY KEY,
  resourceIds VARCHAR(255),
  appSecret VARCHAR(255),
  scope VARCHAR(255),
  grantTypes VARCHAR(255),
  redirectUrl VARCHAR(255),
  authorities VARCHAR(255),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additionalInformation VARCHAR(4096),
  autoApproveScopes VARCHAR(255)
);

DROP TABLE IF EXISTS user;
CREATE TABLE user (
  id BIGINT PRIMARY KEY NOT NULL,
  name VARCHAR(255) NOT NULL,
  login VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS role;
CREATE TABLE role (
  id BIGINT PRIMARY KEY  NOT NULL,
  name VARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS user_role;
CREATE TABLE user_role (
  user_id BIGINT,
  role_id BIGINT,
  FOREIGN KEY  (user_id) REFERENCES user(id),
  FOREIGN KEY (role_id) REFERENCES role(id)
);

insert into user(id, name, login, password) values (1,'Roy-Boy','roy','$2a$06$A7AG6PwXR3O.5sDG38GXSOzLaURA4IOfrXxRh9LZSIAxnvZjJZKaa');
insert into user(id, name, login, password) values (2,'Craig','craig','$2a$06$Km2YyDTKAGscrh4tBeBMoeHjPiiVXPyArhqlwsBDZv8erJfIdfGP2');
insert into user(id, name, login, password) values (3,'Greg','greg','$2a$06$fkDcD24gGh1sKhA81fp6g.XV3T6/C6CRuJ0xHwkXJuIGZmfB2YTJO');
 
insert into role(id, name) values (1,'ROLE_USER');
insert into role(id, name) values (2,'ROLE_ADMIN');
insert into role(id, name) values (3,'ROLE_GUEST'); 

insert into user_role(user_id, role_id) values (1,1);
insert into user_role(user_id, role_id) values (1,2);
insert into user_role(user_id, role_id) values (2,1);
insert into user_role(user_id, role_id) values (3,1);
