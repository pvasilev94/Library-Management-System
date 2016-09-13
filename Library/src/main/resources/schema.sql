CREATE TABLE  books(
  bookId	VARCHAR(29),
  title		VARCHAR(29),
  ISBN		VARCHAR(29),
  author	VARCHAR(29),
  publisher	VARCHAR(29),
  edition	VARCHAR(29),
  yearRelease	VARCHAR(29)
);
CREATE TABLE member(
  memberId	VARCHAR(29),
  memberName	VARCHAR(29),
  address	VARCHAR(29),
  DOB	VARCHAR(29),
  loanLimit	VARCHAR (29),
  loanLenght	VARCHAR(29),
  fines		VARCHAR (29),
);
CREATE TABLE loan(
 bookId	VARCHAR(29),
 memberId	VARCHAR(29),
 loanDate	VARCHAR(29),
 returnDate	VARCHAR(29),
 PRIMARY KEY (bookId, memberId)
 );