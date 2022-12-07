import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class T_C extends JFrame implements ActionListener,ChangeListener{
    
    private JLabel label_title, label_logo;
    private JTextArea textarea_tc;
    private JCheckBox checkbox_agree;
    private JButton button_agree_yes, button_agree_not;
    private JScrollPane scrollpane_tc;
    

    public T_C(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Terms & Conditions");
        setIconImage(new ImageIcon(getClass().getResource("images/title_icon.png")).getImage());


        label_title = new JLabel("Terms & Conditions");
        label_title.setBounds(290,15,250,30);
        label_title.setFont(new Font("Courier",1,20));
        label_title.setForeground(new Color(0,0,0));
        add(label_title);

        textarea_tc = new JTextArea("\n\n                                                       TERMS AND CONDITIONS"+
        "\n\n\n     Last updated January 17, 2012 (21:05)"+
    
         "\n\n\n\n        TABLE OF CONTENTS"+
    
         "\n\n        1. AGREEMENT TO TERMS"+
        "\n         2. INTELLECTUAL PROPERTY RIGHTS"+
        "\n         3. USER REPRESENTATIONS"+
        "\n         4. USER REGISTRATION"+
        "\n         5. PROHIBITED ACTIVITIES"+
        "\n         6. USER GENERATED CONTRIBUTIONS"+
        "\n         7. CONTRIBUTION LICENSE"+
        "\n         8. MOBILE APPLICATION LICENSE"+
        "\n         9. SUBMISSIONS"+
        "\n         10. THIRD-PARTY WEBSITE AND CONTENT"+
        "\n         11. SITE MANAGEMENT"+
        "\n         12. PRIVACY POLICY"+
        "\n         13. TERM AND TERMINATION"+
        "\n         14. MODIFICATIONS AND INTERRUPTIONS"+
        "\n         15. GOVERNING LAW"+
        "\n         16. DISPUTE RESOLUTION"+
        "\n         17. CORRECTIONS"+
        "\n         18. DISCLAIMER"+
        "\n         19. LIMITATIONS OF LIABILITY"+
        "\n         20. INDEMNIFICATION"+
        "\n         21. USER DATA"+
        "\n         22. ELECTRONIC COMMUNICATIONS, TRANSACTIONS, AND SIGNATURES"+
        "\n         23. CALIFORNIA USERS AND RESIDENTS"+
        "\n         24. MISCELLANEOUS"+
        "\n         25. CONTACT US"+
    
        "\n\n1.     AGREEMENT TO TERMS"+
        "\n         These Terms of Use constitute a legally binding agreement made between you,"+
        "\n         whether personally or on behalf of an entity (“you”) and David Air LLC ('Company,'"+
        "\n         “we,' “us,' or “our”), concerning your access to and use of the"+
        "\n         http://www.davidair.com.co website as well as any other media form, media channel,"+
        "\n         mobile website or mobile application related, linked, or otherwise connected thereto"+
        "\n         (collectively, the “Site”). We are registered in Colombia and have our registered office"+
        "\n         at Calle 82B #152BIS - 5, Medellín, Antioquía 250521115. Our VAT number is 19."+
        "\n         You agree that by accessing the Site, you have read, understood, and agreed to be"+
        "\n         bound by all of these Terms of Use. IF YOU DO NOT AGREE WITH ALL OF THESE"+
        "\n         TERMS OF USE, THEN YOU ARE EXPRESSLY PROHIBITED FROM USING THE"+
        "\n         SITE AND YOU MUST DISCONTINUE USE IMMEDIATELY."+
        "\n         Supplemental terms and conditions or documents that may be posted on the Site"+
        "\n         from time to time are hereby expressly incorporated herein by reference. We reserve"+
        "\n         the right, in our sole discretion, to make changes or modifications to these Terms of"+
        "\n         Use from time to time. We will alert you about any changes by updating the “Last"+
        "\n         updated” date of these Terms of Use, and you waive any right to receive specific"+
        "\n         notice of each such change. Please ensure that you check the applicable Terms"+
        "\n         every time you use our Site so that you understand which Terms apply. You will be"+
        "\n         subject to, and will be deemed to have been made aware of and to have accepted,"+
        "\n         he changes in any revised Terms of Use by your continued use of the Site after the"+
        "\n         date such revised Terms of Use are posted."+
        "\n         The information provided on the Site is not intended for distribution to or use by any"+
        "\n         person or entity in any jurisdiction or country where such distribution or use would be"+
        "\n         contrary to law or regulation or which would subject us to any registration"+
        "\n         requirement within such jurisdiction or country. Accordingly, those persons who"+
        "\n         choose to access the Site from other locations do so on their own initiative and are"+
        "\n         solely responsible for compliance with local laws, if and to the extent local laws are"+
        "\n         applicable."+
        "\n         The Site is not tailored to comply with industry-specific regulations (Health Insurance"+
        "\n         Portability and Accountability Act (HIPAA), Federal Information Security Management"+
        "\n         Act (FISMA), etc.), so if your interactions would be subjected to such laws, you may"+
        "\n         not use this Site. You may not use the Site in a way that would violate the GrammLeach-Bliley Act (GLBA)."+
        "\n         The Site is intended for users who are at least 18 years old. Persons under the age"+
        "\n         of 18 are not permitted to use or register for the Site."+
    
    
        "\n\n2.     INTELLECTUAL PROPERTY RIGHTS"+
        "\n         Unless otherwise indicated, the Site is our proprietary property and all source code,"+
        "\n         databases, functionality, software, website designs, audio, video, text, photographs,"+
        "\n         and graphics on the Site (collectively, the “Content”) and the trademarks, service"+
        "\n         marks, and logos contained therein (the “Marks”) are owned or controlled by us or"+
        "\n         licensed to us, and are protected by copyright and trademark laws and various other"+
        "\n         intellectual property rights and unfair competition laws of the United States,"+
        "\n         international copyright laws, and international conventions. The Content and the"+
        "\n         Marks are provided on the Site “AS IS” for your information and personal use only."+
        "\n         Except as expressly provided in these Terms of Use, no part of the Site and no"+
        "\n         Content or Marks may be copied, reproduced, aggregated, republished, uploaded,"+
        "\n         posted, publicly displayed, encoded, translated, transmitted, distributed, sold,"+
        "\n         licensed, or otherwise exploited for any commercial purpose whatsoever, without our"+
        "\n         express prior written permission."+
        "\n         Provided that you are eligible to use the Site, you are granted a limited license to"+
        "\n         access and use the Site and to download or print a copy of any portion of the Content"+
        "\n         to which you have properly gained access solely for your personal, non-commercial"+
        "\n         use. We reserve all rights not expressly granted to you in and to the Site, the Content"+
        "\n         and the Marks."+
    
        "\n\n3.     USER REPRESENTATIONS"+
        "\n         By using the Site, you represent and warrant that: (1) all registration information you"+
        "\n         submit will be true, accurate, current, and complete; (2) you will maintain the"+
        "\n         accuracy of such information and promptly update such registration information as"+
        "\n         necessary; (3) you have the legal capacity and you agree to comply with these Terms"+
        "\n         of Use; (4) you are not a minor in the jurisdiction in which you reside; (5) you will not"+
        "\n         access the Site through automated or non-human means, whether through a bot,"+
        "\n         script, or otherwise; (6) you will not use the Site for any illegal or unauthorized"+
        "\n         purpose; and (7) your use of the Site will not violate any applicable law or regulation."+
        "\n         If you provide any information that is untrue, inaccurate, not current, or incomplete,"+
        "\n         we have the right to suspend or terminate your account and refuse any and all"+
        "\n         current or future use of the Site (or any portion thereof)."+
    
        "\n\n4.     USER REGISTRATION"+
        "\n         You may be required to register with the Site. You agree to keep your password"+
        "\n         confidential and will be responsible for all use of your account and password. We"+
        "\n         reserve the right to remove, reclaim, or change a username you select if we"+
        "\n         determine, in our sole discretion, that such username is inappropriate, obscene, or"+
        "\n         otherwise objectionable."+
    
        "\n\n5.     PROHIBITED ACTIVITIES"+
        "\n         You may not access or use the Site for any purpose other than that for which we"+
        "\n         make the Site available. The Site may not be used in connection with any"+
        "\n         commercial endeavors except those that are specifically endorsed or approved by"+
        "\n         us."+
        "\n         As a user of the Site, you agree not to:"+
        "\n         Systematically retrieve data or other content from the Site to create or compile,"+
        "\n         directly or indirectly, a collection, compilation, database, or directory without"+
        "\n         written permission from us."+
        "\n         Trick, defraud, or mislead us and other users, especially in any attempt to learn"+
        "\n         sensitive account information such as user passwords."+
        "\n         Circumvent, disable, or otherwise interfere with security-related features of the"+
        "\n         Site, including features that prevent or restrict the use or copying of any"+
        "\n         Content or enforce limitations on the use of the Site and/or the Content"+
        "\n         contained therein."+
        "\n         Disparage, tarnish, or otherwise harm, in our opinion, us and/or the Site."+
        "\n         Use any information obtained from the Site in order to harass, abuse, or harm"+
        "\n         another person."+
        "\n         Make improper use of our support services or submit false reports of abuse or"+
        "\n         misconduct."+
        "\n         Use the Site in a manner inconsistent with any applicable laws or regulations."+
        "\n         Engage in unauthorized framing of or linking to the Site."+
        "\n         Upload or transmit (or attempt to upload or to transmit) viruses, Trojan horses,"+
        "\n         or other material, including excessive use of capital letters and spamming"+
        "\n         (continuous posting of repetitive text), that interferes with any party’s"+
        "\n         uninterrupted use and enjoyment of the Site or modifies, impairs, disrupts,"+
        "\n         alters, or interferes with the use, features, functions, operation, or maintenance"+
        "\n         of the Site."+
        "\n         Engage in any automated use of the system, such as using scripts to send"+
        "\n         comments or messages, or using any data mining, robots, or similar data"+
        "\n         gathering and extraction tools."+
        "\n         Delete the copyright or other proprietary rights notice from any Content."+
        "\n         Attempt to impersonate another user or person or use the username of"+
        "\n         another user."+
        "\n         Upload or transmit (or attempt to upload or to transmit) any material that acts"+
        "\n         as a passive or active information collection or transmission mechanism,"+
        "\n         including without limitation, clear graphics interchange formats (“gifs”), 1×1"+
        "\n         pixels, web bugs, cookies, or other similar devices (sometimes referred to as"+
        "\n         “spyware” or “passive collection mechanisms” or “pcms”)."+
        "\n         Interfere with, disrupt, or create an undue burden on the Site or the networks"+
        "\n         or services connected to the Site."+
        "\n         Harass, annoy, intimidate, or threaten any of our employees or agents"+
        "\n         engaged in providing any portion of the Site to you."+
        "\n         Attempt to bypass any measures of the Site designed to prevent or restrict"+
        "\n         access to the Site, or any portion of the Site."+
        "\n         Copy or adapt the Site’s software, including but not limited to Flash, PHP,"+
        "\n         HTML, JavaScript, or other code."+
        "\n         Except as permitted by applicable law, decipher, decompile, disassemble, or"+
        "\n         reverse engineer any of the software comprising or in any way making up a"+
        "\n         part of the Site."+
        "\n         Except as may be the result of standard search engine or Internet browser"+
        "\n         usage, use, launch, develop, or distribute any automated system, including"+
        "\n         without limitation, any spider, robot, cheat utility, scraper, or offline reader that"+
        "\n         accesses the Site, or using or launching any unauthorized script or other"+
        "\n         software."+
        "\n         Use a buying agent or purchasing agent to make purchases on the Site."+
        "\n         Make any unauthorized use of the Site, including collecting usernames and/or"+
        "\n         email addresses of users by electronic or other means for the purpose of"+
        "\n         sending unsolicited email, or creating user accounts by automated means or"+
        "\n         under false pretenses."+
        "\n         Use the Site as part of any effort to compete with us or otherwise use the Site"+
        "\n         and/or the Content for any revenue-generating endeavor or commercial"+
        "\n         enterprise."+
        "\n         Use the Site to advertise or offer to sell goods and services."+
        "\n         Sell or otherwise transfer your profile."+
    
        "\n\n6.     USER GENERATED CONTRIBUTIONS"+
        "\n         The Site does not offer users to submit or post content. We may provide you with the"+
        "\n         opportunity to create, submit, post, display, transmit, perform, publish, distribute, or"+
        "\n         broadcast content and materials to us or on the Site, including but not limited to text,"+
        "\n         writings, video, audio, photographs, graphics, comments, suggestions, or personal"+
        "\n         information or other material (collectively, 'Contributions'). Contributions may be"+
        "\n         viewable by other users of the Site and through third-party websites. As such, any"+
        "\n         Contributions you transmit may be treated in accordance with the Site Privacy Policy."+
        "\n         When you create or make available any Contributions, you thereby represent and"+
        "\n         warrant that:"+
        "\n         The creation, distribution, transmission, public display, or performance, and the"+
        "\n         accessing, downloading, or copying of your Contributions do not and will not"+
        "\n         infringe the proprietary rights, including but not limited to the copyright, patent,"+
        "\n         trademark, trade secret, or moral rights of any third party."+
        "\n         You are the creator and owner of or have the necessary licenses, rights,"+
        "\n         consents, releases, and permissions to use and to authorize us, the Site, and"+
        "\n         other users of the Site to use your Contributions in any manner contemplated"+
        "\n         by the Site and these Terms of Use."+
        "\n         You have the written consent, release, and/or permission of each and every"+
        "\n         identifiable individual person in your Contributions to use the name or likeness"+
        "\n         of each and every such identifiable individual person to enable inclusion and"+
        "\n         use of your Contributions in any manner contemplated by the Site and these"+
        "\n         Terms of Use."+
        "\n         Your Contributions are not false, inaccurate, or misleading."+
        "\n         Your Contributions are not unsolicited or unauthorized advertising, promotional"+
        "\n         materials, pyramid schemes, chain letters, spam, mass mailings, or other"+
        "\n         forms of solicitation."+
        "\n         Your Contributions are not obscene, lewd, lascivious, filthy, violent, harassing,"+
        "\n         libelous, slanderous, or otherwise objectionable (as determined by us)."+
        "\n         Your Contributions do not ridicule, mock, disparage, intimidate, or abuse"+
        "\n         anyone."+
        "\n         Your Contributions are not used to harass or threaten (in the legal sense of"+
        "\n         those terms) any other person and to promote violence against a specific"+
        "\n         person or class of people."+
        "\n         Your Contributions do not violate any applicable law, regulation, or rule."+
        "\n         Your Contributions do not violate the privacy or publicity rights of any third"+
        "\n         party."+
        "\n         Your Contributions do not violate any applicable law concerning child"+
        "\n         pornography, or otherwise intended to protect the health or well-being of"+
        "\n         minors."+
        "\n         Your Contributions do not include any offensive comments that are connected"+
        "\n         to race, national origin, gender, sexual preference, or physical handicap."+
        "\n         Your Contributions do not otherwise violate, or link to material that violates, any"+
        "\n         provision of these Terms of Use, or any applicable law or regulation."+
        "\n         Any use of the Site in violation of the foregoing violates these Terms of Use and may"+
        "\n         result in, among other things, termination or suspension of your rights to use the Site."+
    
        "\n\n        7. CONTRIBUTION LICENSE"+
        "\n         You and the Site agree that we may access, store, process, and use any information"+
        "\n         and personal data that you provide following the terms of the Privacy Policy and your"+
        "\n         choices (including settings)."+
        "\n         By submitting suggestions or other feedback regarding the Site, you agree that we"+
        "\n         can use and share such feedback for any purpose without compensation to you."+
        "\n         We do not assert any ownership over your Contributions. You retain full ownership of"+
        "\n         all of your Contributions and any intellectual property rights or other proprietary rights"+
        "\n         associated with your Contributions. We are not liable for any statements or"+
        "\n         representations in your Contributions provided by you in any area on the Site. You"+
        "\n         are solely responsible for your Contributions to the Site and you expressly agree to"+
        "\n         exonerate us from any and all responsibility and to refrain from any legal action"+
        "\n         against us regarding your Contributions."+
    
        "\n\n        8. MOBILE APPLICATION LICENSE"+
        "\n         Use License"+
        "\n         If you access the Site via a mobile application, then we grant you a revocable, non exclusive, non-transferable, limited right to install and use the mobile application on"+
        "\n         wireless electronic devices owned or controlled by you, and to access and use the"+
        "\n         mobile application on such devices strictly in accordance with the terms and"+
        "\n         conditions of this mobile application license contained in these Terms of Use. You"+
        "\n         shall not: (1) except as permitted by applicable law, decompile, reverse engineer,"+
        "\n         disassemble, attempt to derive the source code of, or decrypt the application; (2)"+
        "\n         make any modification, adaptation, improvement, enhancement, translation, or"+
        "\n         derivative work from the application; (3) violate any applicable laws, rules, or"+
        "\n         regulations in connection with your access or use of the application; (4) remove, alter,"+
        "\n         or obscure any proprietary notice (including any notice of copyright or trademark)"+
        "\n         posted by us or the licensors of the application; (5) use the application for any"+
        "\n         revenue generating endeavor, commercial enterprise, or other purpose for which it is"+
        "\n         not designed or intended; (6) make the application available over a network or other"+
        "\n         environment permitting access or use by multiple devices or users at the same time;"+
        "\n         (7) use the application for creating a product, service, or software that is, directly or"+
        "\n         indirectly, competitive with or in any way a substitute for the application; (8) use the"+
        "\n         application to send automated queries to any website or to send any unsolicited"+
        "\n         commercial e-mail; or (9) use any proprietary information or any of our interfaces or"+
        "\n         our other intellectual property in the design, development, manufacture, licensing, or"+
        "\n         distribution of any applications, accessories, or devices for use with the application."+
        "\n         Apple and Android Devices"+
        "\n         The following terms apply when you use a mobile application obtained from either the"+
        "\n         Apple Store or Google Play (each an “App Distributor”) to access the Site: (1) the"+
        "\n         license granted to you for our mobile application is limited to a non-transferable"+
        "\n         license to use the application on a device that utilizes the Apple iOS or Android"+
        "\n         operating systems, as applicable, and in accordance with the usage rules set forth in"+
        "\n         the applicable App Distributor’s terms of service; (2) we are responsible for providing"+
        "\n         any maintenance and support services with respect to the mobile application as"+
        "\n         specified in the terms and conditions of this mobile application license contained in"+
        "\n         these Terms of Use or as otherwise required under applicable law, and you"+
        "\n         acknowledge that each App Distributor has no obligation whatsoever to furnish any"+
        "\n         maintenance and support services with respect to the mobile application; (3) in the"+
        "\n         event of any failure of the mobile application to conform to any applicable warranty,"+
        "\n         you may notify the applicable App Distributor, and the App Distributor, in accordance"+
        "\n         with its terms and policies, may refund the purchase price, if any, paid for the mobile"+
        "\n         application, and to the maximum extent permitted by applicable law, the App"+
        "\n         Distributor will have no other warranty obligation whatsoever with respect to the"+
        "\n         mobile application; (4) you represent and warrant that (i) you are not located in a"+
        "\n         country that is subject to a U.S. government embargo, or that has been designated"+
        "\n         by the U.S. government as a “terrorist supporting” country and (ii) you are not listed"+
        "\n         on any U.S. government list of prohibited or restricted parties; (5) you must comply"+
        "\n         with applicable third-party terms of agreement when using the mobile application,"+
        "\n         e.g., if you have a VoIP application, then you must not be in violation of their wireless"+
        "\n         data service agreement when using the mobile application; and (6) you acknowledge"+
        "\n         and agree that the App Distributors are third-party beneficiaries of the terms and"+
        "\n         conditions in this mobile application license contained in these Terms of Use, and"+
        "\n         that each App Distributor will have the right (and will be deemed to have accepted"+
        "\n         the right) to enforce the terms and conditions in this mobile application license"+
        "\n         contained in these Terms of Use against you as a third-party beneficiary thereof."+
    
        "\n\n        9. SUBMISSIONS"+
        "\n         You acknowledge and agree that any questions, comments, suggestions, ideas,"+
        "\n         feedback, or other information regarding the Site ('Submissions') provided by you to"+
        "\n         us are non-confidential and shall become our sole property. We shall own exclusive"+
        "\n         rights, including all intellectual property rights, and shall be entitled to the unrestricted"+
        "\n         use and dissemination of these Submissions for any lawful purpose, commercial or"+
        "\n         otherwise, without acknowledgment or compensation to you. You hereby waive all"+
        "\n         moral rights to any such Submissions, and you hereby warrant that any such"+
        "\n         Submissions are original with you or that you have the right to submit such"+
        "\n         Submissions. You agree there shall be no recourse against us for any alleged or"+
        "\n         actual infringement or misappropriation of any proprietary right in your Submissions."+
    
        "\n\n        10. THIRD-PARTY WEBSITE AND CONTENT"+
        "\n         The Site may contain (or you may be sent via the Site) links to other websites ('ThirdParty Websites') as well as articles, photographs, text, graphics, pictures, designs,"+
        "\n         music, sound, video, information, applications, software, and other content or items"+
        "\n         belonging to or originating from third parties ('Third-Party Content'). Such Third-Party"+
        "\n         Websites and Third-Party Content are not investigated, monitored, or checked for"+
        "\n         accuracy, appropriateness, or completeness by us, and we are not responsible for"+
        "\n         any Third-Party Websites accessed through the Site or any Third-Party Content"+
        "\n         posted on, available through, or installed from the Site, including the content,"+
        "\n         accuracy, offensiveness, opinions, reliability, privacy practices, or other policies of or"+
        "\n         contained in the Third-Party Websites or the Third-Party Content. Inclusion of, linking"+
        "\n         to, or permitting the use or installation of any Third-Party Websites or any Third-Party"+
        "\n         Content does not imply approval or endorsement thereof by us. If you decide to leave"+
        "\n         the Site and access the Third-Party Websites or to use or install any Third-Party"+
        "\n         Content, you do so at your own risk, and you should be aware these Terms of Use no"+
        "\n         longer govern. You should review the applicable terms and policies, including privacy"+
        "\n         and data gathering practices, of any website to which you navigate from the Site or"+
        "\n         relating to any applications you use or install from the Site. Any purchases you make"+
        "\n         through Third-Party Websites will be through other websites and from other"+
        "\n         companies, and we take no responsibility whatsoever in relation to such purchases"+
        "\n         which are exclusively between you and the applicable third party. You agree and"+
        "\n         acknowledge that we do not endorse the products or services offered on Third-Party"+
        "\n         Websites and you shall hold us harmless from any harm caused by your purchase of"+
        "\n         such products or services. Additionally, you shall hold us harmless from any losses"+
        "\n         sustained by you or harm caused to you relating to or resulting in any way from any"+
        "\n         Third-Party Content or any contact with Third-Party Websites."+
    
        "\n\n        11. SITE MANAGEMENT"+
        "\n         We reserve the right, but not the obligation, to: (1) monitor the Site for violations of"+
        "\n         these Terms of Use; (2) take appropriate legal action against anyone who, in our sole"+
        "\n         discretion, violates the law or these Terms of Use, including without limitation,"+
        "\n         reporting such user to law enforcement authorities; (3) in our sole discretion and"+
        "\n         without limitation, refuse, restrict access to, limit the availability of, or disable (to the"+
        "\n         extent technologically feasible) any of your Contributions or any portion thereof; (4) in"+
        "\n         our sole discretion and without limitation, notice, or liability, to remove from the Site or"+
        "\n         otherwise disable all files and content that are excessive in size or are in any way"+
        "\n         burdensome to our systems; and (5) otherwise manage the Site in a manner"+
        "\n         designed to protect our rights and property and to facilitate the proper functioning of"+
        "\n         the Site."+
    
        "\n\n        12. PRIVACY POLICY"+
        "\n         We care about data privacy and security. Please review our Privacy"+
        "\n         Policy: http://www.davidair.com.co/privacy-policy-es-and-eng/. By using the Site,"+
        "\n         you agree to be bound by our Privacy Policy, which is incorporated into these Terms"+
        "\n         of Use. Please be advised the Site is hosted in Colombia. If you access the Site from"+
        "\n         any other region of the world with laws or other requirements governing personal"+
        "\n         data collection, use, or disclosure that differ from applicable laws in Colombia, then"+
        "\n         through your continued use of the Site, you are transferring your data to Colombia,"+
        "\n         and you agree to have your data transferred to and processed in Colombia."+
    
        "\n\n        13. TERM AND TERMINATION"+
        "\n         These Terms of Use shall remain in full force and effect while you use the Site."+
        "\n         WITHOUT LIMITING ANY OTHER PROVISION OF THESE TERMS OF USE, WE"+
        "\n         RESERVE THE RIGHT TO, IN OUR SOLE DISCRETION AND WITHOUT NOTICE"+
        "\n         OR LIABILITY, DENY ACCESS TO AND USE OF THE SITE (INCLUDING"+
        "\n         BLOCKING CERTAIN IP ADDRESSES), TO ANY PERSON FOR ANY REASON OR"+
        "\n         FOR NO REASON, INCLUDING WITHOUT LIMITATION FOR BREACH OF ANY"+
        "\n         REPRESENTATION, WARRANTY, OR COVENANT CONTAINED IN THESE TERMS"+
        "\n         OF USE OR OF ANY APPLICABLE LAW OR REGULATION. WE MAY TERMINATE"+
        "\n         YOUR USE OR PARTICIPATION IN THE SITE OR DELETE YOUR ACCOUNT"+
        "\n         AND ANY CONTENT OR INFORMATION THAT YOU POSTED AT ANY TIME,"+
        "\n         WITHOUT WARNING, IN OUR SOLE DISCRETION."+
        "\n         If we terminate or suspend your account for any reason, you are prohibited from"+
        "\n         registering and creating a new account under your name, a fake or borrowed name,"+
        "\n         or the name of any third party, even if you may be acting on behalf of the third party."+
        "\n         In addition to terminating or suspending your account, we reserve the right to take"+
        "\n         appropriate legal action, including without limitation pursuing civil, criminal, and"+
        "\n         injunctive redress."+
    
        "\n\n        14. MODIFICATIONS AND INTERRUPTIONS"+
        "\n         We reserve the right to change, modify, or remove the contents of the Site at any"+
        "\n         time or for any reason at our sole discretion without notice. However, we have no"+
        "\n         obligation to update any information on our Site. We also reserve the right to modify"+
        "\n         or discontinue all or part of the Site without notice at any time. We will not be liable to"+
        "\n         you or any third party for any modification, price change, suspension, or"+
        "\n         discontinuance of the Site."+
        "\n         We cannot guarantee the Site will be available at all times. We may experience"+
        "\n         hardware, software, or other problems or need to perform maintenance related to the"+
        "\n         Site, resulting in interruptions, delays, or errors. We reserve the right to change,"+
        "\n         revise, update, suspend, discontinue, or otherwise modify the Site at any time or for"+
        "\n         any reason without notice to you. You agree that we have no liability whatsoever for"+
        "\n         any loss, damage, or inconvenience caused by your inability to access or use the"+
        "\n         Site during any downtime or discontinuance of the Site. Nothing in these Terms of"+
        "\n         Use will be construed to obligate us to maintain and support the Site or to supply any"+
        "\n         corrections, updates, or releases in connection therewith."+
    
        "\n\n        15. GOVERNING LAW"+
        "\n         These Terms shall be governed by and defined following the laws of Colombia. David"+
        "\n         Air LLC and yourself irrevocably consent that the courts of Colombia shall have"+
        "\n         exclusive jurisdiction to resolve any dispute which may arise in connection with these"+
        "\n         terms."+
    
        "\n\n        16. DISPUTE RESOLUTION"+
        "\n         You agree to irrevocably submit all disputes related to Terms or the relationship"+
        "\n         established by this Agreement to the jurisdiction of the Colombia courts. David Air"+
        "\n         LLC shall also maintain the right to bring proceedings as to the substance of the"+
        "\n         matter in the courts of the country where you reside or, if these Terms are entered"+
        "\n         into in the course of your trade or profession, the state of your principal place of"+
        "\n         business."+
    
        "\n\n        17. CORRECTIONS"+
        "\n         There may be information on the Site that contains typographical errors,"+
        "\n         inaccuracies, or omissions, including descriptions, pricing, availability, and various"+
        "\n         other information. We reserve the right to correct any errors, inaccuracies, or"+
        "\n         omissions and to change or update the information on the Site at any time, without"+
        "\n         prior notice."+
    
        "\n\n        18. DISCLAIMER"+
        "\n         THE SITE IS PROVIDED ON AN AS-IS AND AS-AVAILABLE BASIS. YOU AGREE"+
        "\n         THAT YOUR USE OF THE SITE AND OUR SERVICES WILL BE AT YOUR SOLE"+
        "\n         RISK. TO THE FULLEST EXTENT PERMITTED BY LAW, WE DISCLAIM ALL"+
        "\n         WARRANTIES, EXPRESS OR IMPLIED, IN CONNECTION WITH THE SITE AND"+
        "\n         YOUR USE THEREOF, INCLUDING, WITHOUT LIMITATION, THE IMPLIED"+
        "\n         WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR"+
        "\n         PURPOSE, AND NON-INFRINGEMENT. WE MAKE NO WARRANTIES OR"+
        "\n         REPRESENTATIONS ABOUT THE ACCURACY OR COMPLETENESS OF THE"+
        "\n         SITE’S CONTENT OR THE CONTENT OF ANY WEBSITES LINKED TO THE SITE"+
        "\n         AND WE WILL ASSUME NO LIABILITY OR RESPONSIBILITY FOR ANY (1)"+
        "\n         ERRORS, MISTAKES, OR INACCURACIES OF CONTENT AND MATERIALS, (2)"+
        "\n         PERSONAL INJURY OR PROPERTY DAMAGE, OF ANY NATURE WHATSOEVER,"+
        "\n         RESULTING FROM YOUR ACCESS TO AND USE OF THE SITE, (3) ANY"+
        "\n         UNAUTHORIZED ACCESS TO OR USE OF OUR SECURE SERVERS AND/OR"+
        "\n         ANY AND ALL PERSONAL INFORMATION AND/OR FINANCIAL INFORMATION"+
        "\n         STORED THEREIN, (4) ANY INTERRUPTION OR CESSATION OF"+
        "\n         TRANSMISSION TO OR FROM THE SITE, (5) ANY BUGS, VIRUSES, TROJAN"+
        "\n         HORSES, OR THE LIKE WHICH MAY BE TRANSMITTED TO OR THROUGH THE"+
        "\n         SITE BY ANY THIRD PARTY, AND/OR (6) ANY ERRORS OR OMISSIONS IN ANY"+
        "\n         CONTENT AND MATERIALS OR FOR ANY LOSS OR DAMAGE OF ANY KIND"+
        "\n         INCURRED AS A RESULT OF THE USE OF ANY CONTENT POSTED,"+
        "\n         TRANSMITTED, OR OTHERWISE MADE AVAILABLE VIA THE SITE. WE DO NOT"+
        "\n         WARRANT, ENDORSE, GUARANTEE, OR ASSUME RESPONSIBILITY FOR ANY"+
        "\n         PRODUCT OR SERVICE ADVERTISED OR OFFERED BY A THIRD PARTY"+
        "\n         THROUGH THE SITE, ANY HYPERLINKED WEBSITE, OR ANY WEBSITE OR"+
        "\n         MOBILE APPLICATION FEATURED IN ANY BANNER OR OTHER ADVERTISING,"+
        "\n         AND WE WILL NOT BE A PARTY TO OR IN ANY WAY BE RESPONSIBLE FOR"+
        "\n         MONITORING ANY TRANSACTION BETWEEN YOU AND ANY THIRD-PARTY"+
        "\n         PROVIDERS OF PRODUCTS OR SERVICES. AS WITH THE PURCHASE OF A"+
        "\n         PRODUCT OR SERVICE THROUGH ANY MEDIUM OR IN ANY ENVIRONMENT,"+
        "\n         YOU SHOULD USE YOUR BEST JUDGMENT AND EXERCISE CAUTION WHERE"+
        "\n         APPROPRIATE."+
    
        "\n\n        19. LIMITATIONS OF LIABILITY"+
        "\n         IN NO EVENT WILL WE OR OUR DIRECTORS, EMPLOYEES, OR AGENTS BE"+
        "\n         LIABLE TO YOU OR ANY THIRD PARTY FOR ANY DIRECT, INDIRECT,"+
        "\n         CONSEQUENTIAL, EXEMPLARY, INCIDENTAL, SPECIAL, OR PUNITIVE"+
        "\n         DAMAGES, INCLUDING LOST PROFIT, LOST REVENUE, LOSS OF DATA, OR"+
        "\n         OTHER DAMAGES ARISING FROM YOUR USE OF THE SITE, EVEN IF WE HAVE"+
        "\n         BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES."+
        "\n         NOTWITHSTANDING ANYTHING TO THE CONTRARY CONTAINED HEREIN,"+
        "\n         OUR LIABILITY TO YOU FOR ANY CAUSE WHATSOEVER AND REGARDLESS"+
        "\n         OF THE FORM OF THE ACTION, WILL AT ALL TIMES BE LIMITED TO $1,500.00"+
        "\n         USD. CERTAIN US STATE LAWS AND INTERNATIONAL LAWS DO NOT ALLOW"+
        "\n         LIMITATIONS ON IMPLIED WARRANTIES OR THE EXCLUSION OR LIMITATION"+
        "\n         OF CERTAIN DAMAGES. IF THESE LAWS APPLY TO YOU, SOME OR ALL OF"+
        "\n         THE ABOVE DISCLAIMERS OR LIMITATIONS MAY NOT APPLY TO YOU, AND"+
        "\n         YOU MAY HAVE ADDITIONAL RIGHTS."+
    
        "\n\n        20. INDEMNIFICATION"+
        "\n         You agree to defend, indemnify, and hold us harmless, including our subsidiaries,"+
        "\n         affiliates, and all of our respective officers, agents, partners, and employees, from"+
        "\n         and against any loss, damage, liability, claim, or demand, including reasonable"+
        "\n         attorneys’ fees and expenses, made by any third party due to or arising out of: (1)"+
        "\n         use of the Site; (2) breach of these Terms of Use; (3) any breach of your"+
        "\n         representations and warranties set forth in these Terms of Use; (4) your violation of"+
        "\n         the rights of a third party, including but not limited to intellectual property rights; or (5)"+
        "\n         any overt harmful act toward any other user of the Site with whom you connected via"+
        "\n         the Site. Notwithstanding the foregoing, we reserve the right, at your expense, to"+
        "\n         assume the exclusive defense and control of any matter for which you are required to"+
        "\n         indemnify us, and you agree to cooperate, at your expense, with our defense of such"+
        "\n         claims. We will use reasonable efforts to notify you of any such claim, action, or"+
        "\n         proceeding which is subject to this indemnification upon becoming aware of it."+
    
        "\n\n        21. USER DATA"+
        "\n         We will maintain certain data that you transmit to the Site for the purpose of"+
        "\n         managing the performance of the Site, as well as data relating to your use of the Site."+
        "\n         Although we perform regular routine backups of data, you are solely responsible for"+
        "\n         all data that you transmit or that relates to any activity you have undertaken using the"+
        "\n         Site. You agree that we shall have no liability to you for any loss or corruption of any"+
        "\n         such data, and you hereby waive any right of action against us arising from any such"+
        "\n         loss or corruption of such data."+
    
        "\n\n22. ELECTRONIC COMMUNICATIONS, TRANSACTIONS,"+
        "\n         AND SIGNATURES"+
        "\n         Visiting the Site, sending us emails, and completing online forms constitute electronic"+
        "\n         communications. You consent to receive electronic communications, and you agree"+
        "\n         that all agreements, notices, disclosures, and other communications we provide to"+
        "\n         you electronically, via email and on the Site, satisfy any legal requirement that such"+
        "\n         communication be in writing. YOU HEREBY AGREE TO THE USE OF"+
        "\n         ELECTRONIC SIGNATURES, CONTRACTS, ORDERS, AND OTHER RECORDS,"+
        "\n         AND TO ELECTRONIC DELIVERY OF NOTICES, POLICIES, AND RECORDS OF"+
        "\n         TRANSACTIONS INITIATED OR COMPLETED BY US OR VIA THE SITE. You"+
        "\n         hereby waive any rights or requirements under any statutes, regulations, rules,"+
        "\n         ordinances, or other laws in any jurisdiction which require an original signature or"+
        "\n         delivery or retention of non-electronic records, or to payments or the granting of"+
        "\n         credits by any means other than electronic means."+
    
        "\n\n        23. CALIFORNIA USERS AND RESIDENTS"+
        "\n         If any complaint with us is not satisfactorily resolved, you can contact the Complaint"+
        "\n         Assistance Unit of the Division of Consumer Services of the California Department of"+
        "\n         Consumer Affairs in writing at 1625 North Market Blvd., Suite N 112, Sacramento,"+
        "\n         California 95834 or by telephone at (800) 952-5210 or (916) 445-1254."+
    
        "\n\n        24. MISCELLANEOUS"+
        "\n         These Terms of Use and any policies or operating rules posted by us on the Site or in"+
        "\n         respect to the Site constitute the entire agreement and understanding between you"+
        "\n         and us. Our failure to exercise or enforce any right or provision of these Terms of Use"+
        "\n         shall not operate as a waiver of such right or provision. These Terms of Use operate"+
        "\n         to the fullest extent permissible by law. We may assign any or all of our rights and"+
        "\n         obligations to others at any time. We shall not be responsible or liable for any loss,"+
        "\n         damage, delay, or failure to act caused by any cause beyond our reasonable control."+
        "\n         If any provision or part of a provision of these Terms of Use is determined to be"+
        "\n         unlawful, void, or unenforceable, that provision or part of the provision is deemed"+
        "\n         severable from these Terms of Use and does not affect the validity and enforceability"+
        "\n         of any remaining provisions. There is no joint venture, partnership, employment or"+
        "\n         agency relationship created between you and us as a result of these Terms of Use or"+
        "\n         use of the Site. You agree that these Terms of Use will not be construed against us"+
        "\n         by virtue of having drafted them. You hereby waive any and all defenses you may"+
        "\n         have based on the electronic form of these Terms of Use and the lack of signing by"+
        "\n         the parties hereto to execute these Terms of Use."+
    
        "\n\n        25. CONTACT US"+
        "\n         In order to resolve a complaint regarding the Site or to receive further information"+
        "\n         regarding use of the Site, please contact us at:"+
    
        "\n\n        David Air LLC"+
    
        "\n\n        Calle 82B #152BIS - 5"+
        "\n         Medellín, Antioquía 250521115"+
        "\n         Colombia"+
        "\n         Phone: +57 3107053966"+
        "\n         Fax: 720010203"+
        "\n         admin@davidair.com.co\n\n");
        textarea_tc.setEditable(false);
        textarea_tc.setFont(new Font("Courier",2,14));
        textarea_tc.setForeground(new Color(0,0,0));
        add(textarea_tc);

        scrollpane_tc = new JScrollPane(textarea_tc);
        scrollpane_tc.setBounds(50,70,685,270);
        add(scrollpane_tc);

        checkbox_agree = new JCheckBox("I agree T&C");
        checkbox_agree.setBounds(50,350,250,30);
        checkbox_agree.setFont(new Font("Courier",0,14));
        checkbox_agree.setForeground(new Color(0,0,0));
        checkbox_agree.addChangeListener(this);
        add(checkbox_agree);

        button_agree_yes = new JButton("Next");
        button_agree_yes.setBounds(50,415,100,30);
        button_agree_yes.setFont(new Font("Courier",1,12));
        button_agree_yes.setForeground(new Color(0,0,0));
        button_agree_yes.setEnabled(false);
        button_agree_yes.addActionListener(this);
        add(button_agree_yes);

        button_agree_not = new JButton("Back");
        button_agree_not.setBounds(200,415,100,30);
        button_agree_not.setFont(new Font("Courier",1,12));
        button_agree_not.setForeground(new Color(0,0,0));
        button_agree_not.addActionListener(this);
        add(button_agree_not);

        ImageIcon image_label_logo = new ImageIcon("images/original.png");
        label_logo = new JLabel(image_label_logo);
        label_logo.setBounds(460,325,250,150);
        add(label_logo);
    }

    public void actionPerformed(ActionEvent a_e){

        if(a_e.getSource() == button_agree_yes){
            Vacation i_vacation = new Vacation();
            i_vacation.setBounds(0,0,850,430);
            i_vacation.setVisible(true);
            i_vacation.setResizable(false);
            i_vacation.setLocationRelativeTo(null);
            this.setVisible(false);
        }
        else if(a_e.getSource() == button_agree_not){
            Welcome i_welcome = new Welcome();
            i_welcome.setBounds(0,0,350,450);
            i_welcome.setLocationRelativeTo(null);
            i_welcome.setResizable(false);
            i_welcome.setVisible(true);
            this.setVisible(false);
        }
    }

    public void stateChanged(ChangeEvent c_e){
        
        if(checkbox_agree.isSelected() == true){
            button_agree_yes.setEnabled(true);
            button_agree_not.setEnabled(false);}
        if(checkbox_agree.isSelected() == false){
            button_agree_yes.setEnabled(false);
            button_agree_not.setEnabled(true);}
    }

    public static void main(String args[]){
        T_C i_t_c = new T_C();
        i_t_c.setBounds(0,0,800,500);
        i_t_c.setVisible(true);
        i_t_c.setLocationRelativeTo(null);
        i_t_c.setResizable(false);

    }
}