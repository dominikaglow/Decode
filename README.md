# Decode

Zadaniem klasy Decode jest dekodowanie danych, które będą do niej przekazywane przez protkół komunikacyjny.

Idea działania protokołu:

X0 - koduje 0

XX0 - koduje 1

XXX0 - koduje 2

XXXX0 - koduje 3
W miejscu X może się pojawić jedna jedynka lub więcej.

Strumień danych zaczyna się zakodowanym zerem.
