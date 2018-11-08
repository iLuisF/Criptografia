'''
Proyecto 2: RSA.
Flores Gonzalez Luis Brandon.
Gomez Lopez Diana Valeria
'''
import random

'''
Logaritmo de Euclides para determinar el maximo comun divisor.
Se usan iteraciones para hacer mas rapido para enteros grandes.
'''
def gcd(a, b):
    while b != 0:
        a, b = b, a % b
    return a


'''
Algoritmo extendido de Euclides para encontrar el inverso multiplicativo de dos numeros.
'''
def multiplicative_inverse(e, phi):
    d = 0
    x1 = 0
    x2 = 1
    y1 = 1
    temp_phi = phi
    
    while e > 0:
        temp1 = temp_phi/e
        temp2 = temp_phi - temp1 * e
        temp_phi = e
        e = temp2
        
        x = x2- temp1* x1
        y = d - temp1 * y1
        
        x2 = x1
        x1 = x
        d = y1
        y1 = y
    
    if temp_phi == 1:
        return d + phi

'''
Prueba si un numero es primo o no.
'''
def is_prime(num):
    if num == 2:
        return True
    if num < 2 or num % 2 == 0:
        return False
    for n in xrange(3, int(num**0.5)+2, 2):
        if num % n == 0:
            return False
    return True

'''
Genera llave publica y privada.
'''
def generate_keypair(p, q):
    if not (is_prime(p) and is_prime(q)):
        raise ValueError('Ambos numeros deben ser primos.')
    elif p == q:
        raise ValueError('p y q no pueden ser iguales.')
    
    # 1) n = p*q
    n = p * q

    # 2) Calcula la funcion de Euler(Phi es el coeficiente de n)
    phi = (p-1) * (q-1)

    # 3) Escoge un entero e tal que e y phi(n) son coprimos.
    e = random.randrange(1, phi)

    # 3.1) Usa el algoritmo de euclides para verificar que e y phi(n) son coprimos.
    g = gcd(e, phi)
    while g != 1:
        e = random.randrange(1, phi)
        g = gcd(e, phi)

    # 4) Usa el algoritmo de Euclides Extendido para generar la llave privada.
    d = multiplicative_inverse(e, phi)

    #Regresa un par de llave publica y privada.
    #La llave publica es (e, n) y la llave privada es (d, n)
    return ((e, n), (d, n))

'''
Encriptado mensaje.
'''
def encrypt(pk, plaintext):
    #Desenpaqueta la llave en sus componentes.
    key, n = pk
    #Convierte cada letra en texto plano a numeros basados en el caracter usando a^b mod m
    # C    =       m      ^  e (mod n)
    cipher = [(ord(char) ** key) % n for char in plaintext]
    #Regresa el arreglo de bytes.
    return cipher

'''
Descifrando un mensaje.
'''
def decrypt(pk, ciphertext):
    # Desenpaqueta la llave en sus componentes.
    key, n = pk
    #Genera el texto plano basado en el texto cifrado y la llave usando a^b mod m.
    # m   =       c    ^   d (mod n)
    plain = [chr((char ** key) % n) for char in ciphertext]
    # Regresa el arreglo de bytes como una cadena.
    return ''.join(plain)
    

if __name__ == '__main__':
    '''    
    Detecta si el script esta corriendo directamente por el usuario.
    '''
    print "RSA Cifrado/ Descifrado"
    p = int(raw_input("Ingresa un numero primo (17, 19, 23, etc): "))
    q = int(raw_input("Ingresa un numero primo diferente: "))
    print "Generando tu llave publica/privada..."
    public, private = generate_keypair(p, q)
    print "Tu llave publica es ", public ," y tu llave privada es ", private
    message = raw_input("Ingresa un mensaje para cifrar con tu llave privada: ")
    encrypted_msg = encrypt(private, message)
    print "Tu mensaje cifrado es: "
    print ''.join(map(lambda x: str(x), encrypted_msg))
    print "Descifrando mensaje con llave publica ", public ," . . ."
    print "Tu mensaje es:"
    print decrypt(public, encrypted_msg)
