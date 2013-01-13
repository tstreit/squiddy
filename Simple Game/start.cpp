#include <iostream>
#include <string>
#include <fstream>

void start() {

    std::string name, shipname, race, introstring;
    char k = '0';
    std::ifstream intro;
    std::ofstream captain;
    
    captain.open ("files/character.xml");
    captain << "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" << std::endl;
    captain << "<character>" << std::endl;

    std::cout << "What's your name Cap? ";
    getline (std::cin, name);

    captain << "    <name>" << name << "</name>" << std::endl;

    std::cout << "What's would like to name your starship Captain " << name << "? ";
    getline (std::cin, shipname);

    captain << "    <shipname>" << shipname << "</shipname>" << std::endl;

    std::cout << "\n";
    std::cout << "Welcome a board the " << shipname << " Captain " << name << ".\n";
    std::cout << "\n";
    std::cout << "What race to you belong to? \n";
    std::cout << "[1] Human\n";
    std::cout << "[2] Reptilian\n";
    std::cout << "[3] Mage\n";
    std::cout << "Choice: ";
    
    std::cin >> k;
    std::cout << "\n";

    switch(k) {
       case '1': 
           std::cout << "You choose Human.\n";
           captain << "    <race>Human</race>" << std::endl;
           break;
       case '2': 
           std::cout << "You choose Reptilian.\n";
           captain << "    <race>Reptilian</race>" << std::endl;
           break;
       case '3': 
           std::cout << "You choose Mage.\n";
           captain << "    <race>Mage</race>" << std::endl;
           break;
       default: std::cout << "What race is that?\n";
    }
    
    std::cout << "\n";

    captain << "</character>" << std::endl;
    captain.close();

    intro.open("files/intro.txt");
    getline(intro,introstring);
    std::cout << introstring;
    intro.close();
    
    std::cout << "\n";
    std::cout << "\n";

    std::cin.get();
    return;
}
