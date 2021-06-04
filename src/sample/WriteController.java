package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class WriteController {
    @FXML
    private TextArea inputTA;
    @FXML
    private Button submitBtn;
    @FXML
    private TextArea outputTA;
    @FXML
    private Button backBtn;

    SampleController controller = new SampleController();
    private boolean teach = controller.isTeach();
    private boolean summary = controller.isSummary();
    private boolean transcript = controller.isTranscript();

    @FXML
    public void submitOnClick(ActionEvent ex) {
         if (summary) {
             inputTA.clear();
             outputTA.setText("['Japanese', 'islands', 'two', 'Korea', 'countries', 'dispute', 'historical', 'claims']\n" +
                     "Summarize Text: \n" +
                     " South korea’s denial of entry to three japanese lawmakers attempting to visit the disputed islands of dokdo/takeshima is the latest in a long series of tit-for-tats between the two countries.the rocky outcrop, known as dokdo in south korea and takeshima in japan, is considered by both countries part of their own respective territories, and the dispute over them has been an ongoing spoiler in bilateral relations. add in an entanglement of historical regional resentments and a very important truth emerges: from the south korean perspective, the dispute over these rocky outcrops is the big picture.the emotional potency of the ‘dokdo’ issue in south korea reveals just how powerful historical memory is. the south korean government must for its part be able to demonstrate to its citizens that japan isn’t ignoring the link between their claims to the islands and the 20th century colonization of the country. from the south korean perspective, losing ‘dokdo’ would be akin to the post-facto legitimization of japanese colonial rule\n"
                     );

         }else if (transcript) {
             inputTA.clear();
             outputTA.setText("South Korea’s denial of entry to three Japanese lawmakers attempting to visit the disputed islands of Dokdo/Takeshima is the latest in a long series of tit-for-tats between the two countries.The rocky outcrop, known as Dokdo in South Korea and Takeshima in Japan, is considered by both countries part of their own respective territories, and the dispute over them has been an ongoing spoiler in bilateral relations. Last month, the Japanese government told its Foreign Ministry staff not to use Korean Airlines for a month, in response to the company’s decision to conduct the inaugural flight of its A380 passenger jet above the isles.The Liberal Democratic Party lawmakers’ attempt to enter ‘Dokdo’, via South Korea, meanwhile, had been long anticipated. Indeed, the Lee Myung Bak government in Seoul had advised the conservative Japanese politicians to refrain from visiting, given the heated civil response it would elicit throughout South Korea.On the face of it, the two countries have every reason to overcome this seemingly petty territorial dispute and reach an agreement over resource sharing in their neighbouring waters. Given how much there is at stake in Northeast Asia – North Korea’s nuclear ambitions, rivalry between the United States and China, latent military hostilities across the Taiwan Strait – the two countries would do well to move past the Dokdo/Takeshima dispute and instead focus on the big picture of peace and stability in Northeast Asia. However, to try to understand South Korea-Japan relations by focusing on the dynamics of the contemporary relationship is to get things upside-down. Add in an entanglement of historical regional resentments and a very important truth emerges: from the South Korean perspective, the dispute over these rocky outcrops is the big picture.The emotional potency of the ‘Dokdo’ issue in South Korea reveals just how powerful historical memory is. This issue brings together all Koreans, no matter what their political inclination – a rare occurrence in a country that is itself deeply ideologically and politically divided.Get briefed on the story of the week, and developing stories to watch across the Asia-Pacific.It’s this historical memory that is responsible for Korea’s unwillingness to take this dispute to the International Court of Justice (ICJ). From the South Korean perspective, losing ‘Dokdo’ would be akin to the post-facto legitimization of Japanese colonial rule. On the one hand, Koreans think that as long as they have effective jurisdiction, there’s no point taking the risk that they may lose the islands. But more importantly, referral of the case to the ICJ appears to concede that Japanese claims to the islands are valid.For Koreans, then, this latest incident invokes strong nationalist sentiments and lingering resentment over the war crimes committed by the Japanese during their occupation of the peninsula. Thus, while outsiders counsel calm and meeting half-way, this will be a very difficult sell for the Lee government under current circumstances. It’s important to understand the strong emotional significance of the islands and the role that national identity plays – in both countries, but particularly in Korea. Any concessions on the part of Korean lawmakers would be akin to political suicide, and so they are unlikely. Likewise, it’s improbable that Japan will simply stand back from the dispute and hand over sovereignty. It’s also clear that, for as long as the two countries remain unable to even begin public conversations over the matter, diplomatic relations will improve only very slowly, if at all.Conversations need to begin and they need to go straight to the core of the issue: an acknowledgement of how deeply the Japanese occupation of Korea strikes at the heart of national identity in that country, and the symbolic role that the Dokdo/Takeshima island dispute plays in this. A solution thus demands that Japan take the first step and acknowledge that Korean claims to the territory are closely linked to historical resentments over the behaviour of colonial Japan. Japan’s annexation of the islands was among the first in a series of actions that led to the colonization of the peninsula, and Korean outrage to Japan’s ongoing claims to the territory has everything to do with this and little to do with the legalistic historical arguments the Japanese have been putting on the table to support their claims. The South Korean government must for its part be able to demonstrate to its citizens that Japan isn’t ignoring the link between their claims to the islands and the 20th century colonization of the country. Only then can the leadership in Seoul stop the reactive decision making and make bold efforts to shift the domestic conversation about how to move forward with the Japan-South Korea relationship. After all, cooperation between these two countries is in the interests of the entire region.Dong-Joon Park is a Resident Kelly Research Fellow at Pacific Forum CSIS. Danielle Chubb is a Resident Vasey Research Fellow at Pacific Forum CSIS.\n Summarize Text: \n south korea’s denial of entry to three japanese lawmakers attempting to visit the disputed islands of dokdo/takeshima is the latest in a long series of tit-for-tats between the two countries.the rocky outcrop, known as dokdo in south korea and takeshima in japan, is considered by both countries part of their own respective territories, and the dispute over them has been an ongoing spoiler in bilateral relations. add in an entanglement of historical regional resentments and a very important truth emerges: from the south korean perspective, the dispute over these rocky outcrops is the big picture.the emotional potency of the ‘dokdo’ issue in south korea reveals just how powerful historical memory is. the south korean government must for its part be able to demonstrate to its citizens that japan isn’t ignoring the link between their claims to the islands and the 20th century colonization of the country. from the south korean perspective, losing ‘dokdo’ would be akin to the post-facto legitimization of japanese colonial rule");
         } else {
             inputTA.clear();
             outputTA.setText("the rocky outcrop, known as dokdo in south korea and takeshima in japan, is considered by both countries part of their own respective territories, and the dispute over them has been an ongoing spoiler in bilateral relations.\n add in an entanglement of historical regional resentments and a very important truth emerges: from the south korean perspective, the dispute over these rocky outcrops is the big picture.\nthe emotional potency of the ‘dokdo’ issue in south korea reveals just how powerful historical memory is.");
         }// The text written will be auto-generated in the real thing, not pre-written like before
    }

    public void backOnClick(ActionEvent ex) throws IOException {
        controller.setTeach(false);
        controller.setTranscript(false);
        controller.setSummary(false);

        Stage appStage;
        Parent root;
        appStage = (Stage) ((Node)ex.getSource()).getScene().getWindow();

        root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        appStage.getScene().setRoot(root);
        appStage.show();
    }
}
