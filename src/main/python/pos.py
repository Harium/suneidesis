import sys
import spacy

model = sys.argv[1]
nlp = spacy.load(model)
document = nlp(sys.argv[2])
for token in document:
    #print(token.lemma_, token.pos_, token.dep_)
    print(token.lemma_, token.tag_)
