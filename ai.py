from nltk.corpus import stopwords
from nltk.cluster.util import cosine_distance
import numpy as np
import networkx as nx
from math import sqrt


def sentence_similarity(ls, ls1, stopwords):
    for i in range(len(ls)):
        ls[i]=ls[i].lower()
    for i in range(len(ls1)):
        ls1[i]=ls1[i].lower()

    all_words = list(set(ls + ls1))
    vector1 = [0] * len(all_words)
    vector2 = [0] * len(all_words)
    for w in ls:
        if w in stopwords:
            continue
        vector1[all_words.index(w)] += 1
    for w in ls1:
        if w in stopwords:
            continue
        vector2[all_words.index(w)] += 1
    allwords = list(ls + ls1)
    
    return (np.dot(vector1, vector2) / (sqrt(np.dot(vector1, vector1)) * sqrt(np.dot(vector2,vector2))))

def generate_summary(file_name, top_n):
    stop_words = ['i', 'me', 'my', 'myself', 'we', 'our', 'ours', 'ourselves', 'you', "you're", "you've", "you'll", "you'd", 'your', 'yours', 'yourself', 'yourselves', 'he', 'him', 'his', 'himself', 'she', "she's", 'her', 'hers', 'herself', 'it', "it's", 'its', 'itself', 'they', 'them', 'their', 'theirs', 'themselves', 'what', 'which', 'who', 'whom', 'this', 'that', "that'll", 'these', 'those', 'am', 'is', 'are', 'was', 'were', 'be', 'been', 'being', 'have', 'has', 'had', 'having', 'do', 'does', 'did', 'doing', 'a', 'an', 'the', 'and', 'but', 'if', 'or', 'because', 'as', 'until', 'while', 'of', 'at', 'by', 'for', 'with', 'about', 'against', 'between', 'into', 'through', 'during', 'before', 'after', 'above', 'below', 'to', 'from', 'up', 'down', 'in', 'out', 'on', 'off', 'over', 'under', 'again', 'further', 'then', 'once', 'here', 'there', 'when', 'where', 'why', 'how', 'all', 'any', 'both', 'each', 'few', 'more', 'most', 'other', 'some', 'such', 'no', 'nor', 'not', 'only', 'own', 'same', 'so', 'than', 'too', 'very', 's', 't', 'can', 'will', 'just', 'don', "don't", 'should', "should've", 'now', 'd', 'll', 'm', 'o', 're', 've', 'y', 'ain', 'aren', "aren't", 'couldn', "couldn't", 'didn', "didn't", 'doesn', "doesn't", 'hadn', "hadn't", 'hasn', "hasn't", 'haven', "haven't", 'isn', "isn't", 'ma', 'mightn', "mightn't", 'mustn', "mustn't", 'needn', "needn't", 'shan', "shan't", 'shouldn', "shouldn't", 'wasn', "wasn't", 'weren', "weren't", 'won', "won't", 'wouldn', "wouldn't"]
    summarize_text = []

    file = open(file_name, "r",encoding="utf8")
    filedata = file.readlines()
    
    article = filedata[0].split(". ")
    sentences = []

    for sentence in article:
        #print(sentence)
        sentences.append(sentence.split(" "))
    
    word_frequencies = {}
   # print(sentences)
    for s in sentences:
        for word in s:
            if word not in stop_words:
                if word not in word_frequencies.keys():
                    word_frequencies[word] = 1
                else:
                    word_frequencies[word] += 1
    sortlst = []
    for word in word_frequencies.keys():
        if word_frequencies[word]>=5:
            sortlst.append(word)
    print(sortlst)
    
    sentence_similarity_martix = np.zeros((len(sentences), len(sentences)))
    for i in range(len(sentences)):
        for j in range(len(sentences)):
            if i != j:
                sentence_similarity_martix[i][j] = sentence_similarity(sentences[i], sentences[j], stop_words)
    sentence_similarity_graph = nx.from_numpy_array(sentence_similarity_martix)
    weight = nx.pagerank(sentence_similarity_graph)
    ranked_sentence = sorted(((weight[i],s) for i,s in enumerate(sentences)), reverse=True)    
    #print("Indexes of top ranked_sentence order are ", ranked_sentence)    
    #print(len(ranked_sentence))
    for i in range(top_n):
      summarize_text.append(" ".join(ranked_sentence[i][1]))
    print("Summarize Text: \n", ". ".join(summarize_text))
      #print(stop_words)
generate_summary( "msft.txt", 4)
