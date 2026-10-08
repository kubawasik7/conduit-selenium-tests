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