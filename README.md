# CoronaVirus
Programs analyzing genome sequence of Covid-19



A DNA (or RNA) sequence is a simply a long string containing only the characters a, c, g, t. These three text files each consist of a single, long (almost 4000 characters) DNA sequence:

SARSCoV2-S-gene-CA.txt
SARSCoV2-S-gene-IL.txt
SARSCoV2-S-gene-WH.txt

Each of these is the same gene in different strains of the SARS-CoV-2 virus, that is, the virus that causes COVID-19. These sequences were collected in three widely separated places (California, Illinois, Wuhan). This particular gene codes for the S protein in the virus.


In an organism, the DNA sequence for a gene is translated into an amino acid sequence for a protein. This translation is done by taking groups of three DNA letters (this is called a codon) and then looking up in a table the amino acid that codon represents. Because there are four DNA letters and each codon contains three letters, there are 64 possible codons. Amino acids are represented by a three-letter abbreviation. Here are the first few rows of the translation table:
(View Raw for this part to display properly)

Examples:

Codon     Amino acid Abbreviation     Amino acid full name
AAA	      Lys	                        Lysine
AAC	      Asn	                        Asparagine
AAG	      Lys	                        Lysine
AAT	      Asn	                        Asparagine
ACA	      Thr	                        Threonine
ACC	      Thr	                        Threonine
ACG	      Thr	                        Threonine
ACT	      Thr	                        Threonine
AGA	      Arg	                        Arginine
