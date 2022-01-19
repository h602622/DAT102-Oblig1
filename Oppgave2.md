# Oppgave 2

**a)**

* i) O(n<sup>2</sup>)
* ii) O(n)
* iii) O(n<sup>3</sup>)
* iv) O(log<sub>2</sub>n)

**b)**

Gjennom testing har vi sett at løkken utføres 2 ganger for `n = 4`, 3 ganger
for `n = 8`, 4 ganger for for `n = 16`, osv. Dette betyr at antall
tilordninger er log<sub>2</sub>n og effektiviteten er O(log<sub>2</sub>n).

**c)**

Den yttre løkken utføres n ganger. Den indre løkken utføres log<sub>2</sub>n
ganger. Dette betyr at antall tilordninger er nlog<sub>2</sub>n og
effektiviteten er O(nlog<sub>2</sub>n).

**d)**

O(n<sup>2</sup>) for areal og O(n) for omkrets der `n` er radius `r`

**e)**

O(n<sup>2</sup>) fordi at man må i verste fall må sammenligne hvert element
med alle andre element (omtrent n*n ganger)

**f)**

* i) O(n<sup>3</sup>)
* ii) O(log<sub>2</sub>n)
* iii) O(nlog<sub>2</sub>n)
* iv) O(n)
* Rangert fra best til verst: ii, iv, iii og i.

**g)**

Vekstfunksjonen til metoden er `T(n) = cn` fordi løkken i funksjonen er linær.
`c` er en konstant for antall millisekunder det tar å utføre operasjonen
`k = k + 5`. Algoritmen tok ca. 115 millisekunder når `n = 100000000`, noe som
betyr at `c = 0.00000115`.

