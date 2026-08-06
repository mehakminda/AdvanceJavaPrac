SpringSecurity01 : what does adding spring security dependency do in a project. default user and hardcoded user
SpringSecurity02 : security filters, Stateful will have same session ID, passing csrf token for non-get request
SpringSecurity03 : adding custom security configuration . Stateless request, nocsrf token requied for non-get request , different session id
SpringSecurity04 : adding inmemory users(they are sttaic users)
SpringSecurity05 : login into user present in db. (Added a authprovider to read db user, UserDetailsService and Userdetails)
SpringSecurity06 : Added a Usercontroller to register a new user, but its in plain text
SpringSecurity07 : hash password (hash existing in db and while loggining also it should be hashed and while registeration also it should be hashed)
-----
jwt and Oauth
SpringSecurity08 :

---------------------------------------------------------------------------------------------------------------------------------------------
											            SECUIRTY CONCEPTS
---------------------------------------------------------------------------------------------------------------------------------------------
Hashing vs encryption vs encoding:

encoding is changing format of the data. 
Its reversible
eg: img -> text 

hashing is
Its irreversible
We need to add salt

encryption: is encryption data with keys(aes/res) 
techniques: symmetric/assymmetric (public-private keys)
Its reversible

- Encoding: Used for compatibility
- Encryption: Used for protection
- Hashing: Used for verification

https://www.youtube.com/watch?v=6VXJNhyzbOE

---------------------------------------------------------------------------------------------------------------------------------------------
Refresh token, access token, Bearer token, JWT token

JWT token : payload method signature
https://www.youtube.com/watch?v=P2CPd9ynFLg
https://share.google/aimode/ANrVrvYFgof7egf2T

---------------------------------------------------------------------------------------------------------------------------------------------
Types of Authentication 

1. Basic
2. Token based
3. OAuth
4. OpenIDConnect
5. SAML (login once and access all related apps, like microsoft office)
6. MFA
7. SSO

https://www.youtube.com/watch?v=_lTECv25N2U&t=63s

---------------------------------------------------------------------------------------------------------------------------------------------