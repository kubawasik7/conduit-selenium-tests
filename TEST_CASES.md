# Test Cases

## Login

### TC-LOGIN-001 - Successful login

**ID:** TC-LOGIN-001

**Title:** Successful login

**Preconditions:**
- User has a registered account.

**Test data:**
- Valid user credentials stored in `test-data.properties`.

**Test steps:**
1. Open the login page.
2. Enter a valid email address.
3. Enter a valid password.
4. Click "Sign in".

**Expected result:**
- User is successfully logged in.
- The home page is displayed.
- The user's profile is visible.

**Actual result:**
- User was successfully logged in.
- The home page was displayed.
- The user's profile was visible.

**Status:** Pass

### TC-LOGIN-002 - Login with invalid email address format
**ID:** TC-LOGIN-002

**Title:** Login with invalid email address format

**Preconditions:**
- User has a registered account.

**Test data:**
- Email: invalidEmail-gmail.com
- Password: Valid password stored in `test-data.properties`.

**Test steps:**
1. Open the login page.
2. Enter an invalid email address.
3. Enter a valid password.
4. Click "Sign In".

**Expected result:**
- User is not logged in.
- The error message **"Invalid email or password"** is displayed.
- User remains on the logging page.

**Actual result:**
- User was not logged in.
- The error message **"Invalid email or password"** was displayed.
- User remained on the logging page.

**Status:** Pass

### TC-LOGIN-003 - Login with unregistered email address
**ID:** TC-LOGIN-003

**Title:** Login with unregistered email address

**Preconditions:**
- User has a registered account.

**Test data:**
- Email: UnregisteredEmail@test.pl
- Password: Valid user password stored in `test-data.properties`.

**Test steps:**
1. Open the login page.
2. Enter an invalid email address.
3. Enter a valid password.
4. Click "Sign In".

**Expected result:**
- User is not logged in.
- The error message **"Invalid email or password"** is displayed.
- User remains on the logging page.

**Actual result:**
- User was not logged in.
- The error message **"Invalid email or password"** was displayed.
- User remained on the logging page.

**Status:** Pass

### TC-LOGIN-004 - Login with invalid password
**ID:** TC-LOGIN-004

**Title:** Login with invalid password

**Preconditions:**
- User has a registered account.

**Test data:**
- Email: Valid user email address stored in `test-data.properties`.
- Password: InvalidPassword123!

**Test steps:**
1. Open the login page.
2. Enter a valid email address.
3. Enter an invalid password.
4. Click "Sign In".

**Expected result:**
- User is not logged in.
- The error message **"Invalid email or password"** is displayed.
- User remains on the logging page.

**Actual result:**
- User was not logged in.
- The error message **"Invalid email or password"** was displayed.
- User remained on the logging page.

**Status:** Pass

### TC-LOGIN-005 - Login with empty email field
**ID:** TC-LOGIN-005

**Title:** Login with empty email field

**Preconditions:**
- User has a registered account.

**Test data:**
- Password: Valid user password stored in `test-data.properties`.

**Test steps:**
1. Open the login page.
2. Leave email address field empty.
3. Enter a valid password.
4. Click "Sign In".

**Expected result:**
- User is not logged in.
- The error message **"Invalid email or password"** is displayed.
- User remains on the logging page.

**Actual result:**
- User was not logged in.
- The error message **"Invalid email or password"** was displayed.
- User remained on the logging page.

**Status:** Pass

### TC-LOGIN-006 - Login with empty password field
**ID:** TC-LOGIN-006

**Title:** Login with empty password field

**Preconditions:**
- User has a registered account.

**Test data:**
- Email: Valid email address stored in `test-data.properties`.

**Test steps:**
1. Open the login page.
2. Enter a valid email address.
3. Leave password field empty
4. Click "Sign In".

**Expected result:**
- User is not logged in.
- The error message **"Invalid email or password"** is displayed.
- User remains on the logging page.

**Actual result:**
- User was not logged in.
- The error message **"Invalid email or password"** was displayed.
- User remained on the logging page.

**Status:** Pass

## Register
### TC-REGISTER-001 - Successful register
**ID:** TC-REGISTER-001

**Title:** Successful register

**Preconditions:**
- User does not have a registered account.

**Test data:**
- Username: Valid username stored in `test-data.properties`.
- Email: Valid email address stored in `test-data.properties`.
- Password: Valid password stored in `test-data.properties`.

**Test steps:**
1. Open the register page.
2. Enter a valid username.
3. Enter a valid email address.
4. Enter a valid password.
5. Click "Sign Up".

**Expected result:**
- User is registered successfully.
- The home page is displayed.
- The user's profile is visible.

**Actual result:**
- User was registered successfully.
- The home page was displayed.
- The user's profile was visible.

**Status:** Pass

### TC-REGISTER-002 - Registration with empty username
**ID:** TC-REGISTER-002

**Title:** Registration with empty username

**Preconditions:**
- User does not have a registered account.

**Test data:**
- Email: Valid email address stored in `test-data.properties`.
- Password: Valid password stored in `test-data.properties`.

**Test steps:**
1. Open the registration page.
2. Leave username empty.
3. Enter a valid email address.
4. Enter a valid password.
5. Click "Sign Up".

**Expected result:**
- User is not registered.
- The browser displays a required-field validation message.
- The user remains on registration page.

**Actual result:**
- User was not registered.
- The browser displayed a required-field validation message.
- The user remained on registration page.

**Status:** Pass

### TC-REGISTER-003 - Registration with empty password

**ID:** TC-REGISTER-003

**Title:** Registration with empty password

**Preconditions:**
- User does not have a registered account.

**Test data:**
- Username: Valid username stored in `test-data.properties`.
- Email: Valid email address stored in `test-data.properties`.

**Test steps:**
1. Open the registration page.
2. Enter a valid username.
3. Enter a valid email address.
4. Leave the password field empty.
5. Click "Sign Up".

**Expected result:**
- User is not registered.
- The browser displays a required-field validation message.
- The user remains on the registration page.

**Actual result:**
- User was not registered.
- The browser displayed a required-field validation message.
- The user remained on the registration page.

**Status:** Pass

### TC-REGISTER-004 - Registration with empty email address

**ID:** TC-REGISTER-004

**Title:** Registration with empty email address

**Preconditions:**
- User does not have a registered account.

**Test data:**
- Username: Valid username stored in `test-data.properties`.
- Password: Valid password stored in `test-data.properties`.

**Test steps:**
1. Open the registration page.
2. Enter a valid username.
3. Leave the email address field empty.
4. Enter a valid password.
5. Click "Sign Up".

**Expected result:**
- User is not registered.
- The browser displays a required-field validation message.
- The user remains on the registration page.

**Actual result:**
- User was not registered.
- The browser displayed a required-field validation message.
- The user remained on the registration page.

**Status:** Pass

### TC-REGISTER-005 - Registration with invalid email address

**ID:** TC-REGISTER-005

**Title:** Registration with invalid email address

**Preconditions:**
- User does not have a registered account.

**Test data:**
- Username: Valid username stored in `test-data.properties`.
- Email: `invalidEmail-gmail.com`
- Password: Valid password stored in `test-data.properties`.

**Test steps:**
1. Open the registration page.
2. Enter a valid username.
3. Enter an invalid email address.
4. Enter a valid password.
5. Click "Sign Up".

**Expected result:**
- User is not registered.
- The browser displays an email-format validation message.
- The user remains on the registration page.

**Actual result:**
- User was not registered.
- The browser displayed an email-format validation message.
- The user remained on the registration page.

**Status:** Pass

### TC-REGISTER-006 - Registration with existing username

**ID:** TC-REGISTER-006

**Title:** Registration with existing username

**Preconditions:**
- An account with the specified username already exists.

**Test data:**
- Username: Existing username.
- Email: Unique, valid email address.
- Password: Valid password stored in `test-data.properties`.

**Test steps:**
1. Open the registration page.
2. Enter an existing username.
3. Enter a unique, valid email address.
4. Enter a valid password.
5. Click "Sign Up".

**Expected result:**
- User is not registered.
- The error message **"Registration failed. Username or email might be taken."** is displayed.
- The user remains on the registration page.

**Actual result:**
- User was not registered.
- The error message **"Registration failed. Username or email might be taken."** was displayed.
- The user remained on the registration page.

**Status:** Pass

### TC-REGISTER-007 - Registration with existing email address

**ID:** TC-REGISTER-007

**Title:** Registration with existing email address

**Preconditions:**
- An account with the specified email address already exists.

**Test data:**
- Username: Unique username.
- Email: Existing email address.
- Password: Valid password stored in `test-data.properties`.

**Test steps:**
1. Open the registration page.
2. Enter a unique username.
3. Enter an existing email address.
4. Enter a valid password.
5. Click "Sign Up".

**Expected result:**
- User is not registered.
- The error message **"Registration failed. Username or email might be taken."** is displayed.
- The user remains on the registration page.

**Actual result:**
- User was not registered.
- The error message **"Registration failed. Username or email might be taken."** was displayed.
- The user remained on the registration page.

**Status:** Pass

