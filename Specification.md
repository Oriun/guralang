# The specification of the GuraLang
(highly inspired by the chicken lang : http://web.archive.org/web/20180420010949/http://torso.me/chicken-spec)

| # (number of A) | Name  | Description
|---|---|---|
| 0 | (ce)A(se)  | stop the interpreter and print the stack  |
| 1  | A  | push "A" into the stack |
| 2  | A(dd)  | Adds the two topmost value in the stack  |
| 3 | (subtr)A(ct) | substract the two topmost value in the stack |
| 4 | (m)A(gnify) | multiply the two topmost value in the stack |
| 5 | (comp)a(re) | Remove the two topmost value in the stack and compare them, if the two are identical, push a "true" in the stack, else push a "false"
| 6 | a(sk) | Not implemented since the A language must the most simple language possible
| 7 | (not)A(sk) | Not implemented since the A language must the most simple language possible
| 8 | (j)A(mp) | jump to a different instruction if the condition is true, the first value in the stack is the offset and the second value is the condition
| 9 | (C)A(nvert) | convert the first value in the stack to his ASCII corresponding code
| A |  | push A-10 "A" in the stack