package org.osate.xtext.aadl2.properties.util;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.util.Aadl2Util;

import com.google.inject.Inject;

public class EMFIndexRetrieval {


	@Inject
	private static ResourceDescriptionsProvider rdp ; 

	@Inject 
	private static IResourceServiceProvider.Registry rspr;
	 
	 public static void registerResourceProviders(ResourceDescriptionsProvider frdp, IResourceServiceProvider.Registry frspr)
	 {
		 rdp = frdp;
		 rspr = frspr;
	 }

	    
	 private static IResourceDescription.Manager getManager(Resource res) {
	   IResourceServiceProvider resourceServiceProvider = 
	     rspr.getResourceServiceProvider(res.getURI());
	   return resourceServiceProvider.getResourceDescriptionManager();
	 } 

	 /**
	 * get all packages in workspace by looking them up in EMF index 
	 * @param res resource
	 * @return list of AADL packages in IEObjectDescription format
	 */
	 @Deprecated
	 public static EList <IEObjectDescription> getAllPackagesInWorkspace(){
	 	 EList <IEObjectDescription> packlist = new BasicEList<IEObjectDescription>();
	 	IResourceDescriptions rds= rdp.getResourceDescriptions(OsateResourceUtil.getResourceSet());
	 	 Iterable<IEObjectDescription> packagedlist = rds.getExportedObjectsByType(Aadl2Package.eINSTANCE.getAadlPackage());
	 	 for (IEObjectDescription eod : packagedlist) {
	 			 packlist.add(eod);
	 	 }
	 	 return packlist;
	 }

	 /**
	 * get all packages in workspace by looking them up in EMF index 
	 * @param res resource
	 * @return list of AADL packages in IEObjectDescription format
	 */
	 public static EList <IEObjectDescription> getAllPackagesInWorkspace(EObject context){
	 	 EList <IEObjectDescription> packlist = new BasicEList<IEObjectDescription>();
	 	IResourceDescriptions rds= rdp.getResourceDescriptions(context.eResource().getResourceSet());
	 	 Iterable<IEObjectDescription> packagedlist = rds.getExportedObjectsByType(Aadl2Package.eINSTANCE.getAadlPackage());
	 	 for (IEObjectDescription eod : packagedlist) {
	 			 packlist.add(eod);
	 	 }
	 	 return packlist;
	 }

	 /**
	 * get package in workspace by looking it up in EMF index 
	 * @param pname String package name
	 * @return AADL package
	 */
	 @Deprecated
	 public static AadlPackage getPackageInWorkspace(String pname){
		 IResourceDescriptions rds= rdp.getResourceDescriptions(OsateResourceUtil.getResourceSet());
	 	 Iterable<IEObjectDescription> packagedlist = rds.getExportedObjectsByType(Aadl2Package.eINSTANCE.getAadlPackage());
	 	 for (IEObjectDescription eod : packagedlist) {
	 			 if (eod.getName().toString().equalsIgnoreCase(pname)) {
 					 EObject res = eod.getEObjectOrProxy();
 					 res = EcoreUtil.resolve(res, OsateResourceUtil.getResourceSet());
 					if (!Aadl2Util.isNull(res)) return (AadlPackage)res;
	 			 }
	 	 }
	 	 return null;
	 }

	 /**
	 * get package in workspace by looking it up in EMF index 
	 * @param pname String package name
	 * @return AADL package
	 */
	 public static AadlPackage getPackageInWorkspace(EObject context,String pname){
		 IResourceDescriptions rds= rdp.getResourceDescriptions(context.eResource().getResourceSet());
	 	 Iterable<IEObjectDescription> packagedlist = rds.getExportedObjectsByType(Aadl2Package.eINSTANCE.getAadlPackage());
	 	 for (IEObjectDescription eod : packagedlist) {
	 			 if (eod.getName().toString().equalsIgnoreCase(pname)) {
 					 EObject res = eod.getEObjectOrProxy();
 					 res = EcoreUtil.resolve(res, OsateResourceUtil.getResourceSet());
 					if (!Aadl2Util.isNull(res)) return (AadlPackage)res;
	 			 }
	 	 }
	 	 return null;
	 }

	 /**
	 * get all property sets in workspace by looking them up in EMF index 
	 * @param res resource
	 * @return list of property sets in IEObjectDescription format
	 */
	 @Deprecated
	 public static EList <IEObjectDescription> getAllPropertySetsInWorkspace(){
	 	 EList <IEObjectDescription> packlist = new BasicEList<IEObjectDescription>();
	 	IResourceDescriptions rds= rdp.getResourceDescriptions(OsateResourceUtil.getResourceSet());
	 	 Iterable<IEObjectDescription> packagedlist = rds.getExportedObjectsByType(Aadl2Package.eINSTANCE.getPropertySet());
	 	 for (IEObjectDescription eod : packagedlist) {
	 			 packlist.add(eod);
	 	 }
	 	 return packlist;
	 }

	 /**
	 * get all property sets in workspace by looking them up in EMF index 
	 * @param res resource
	 * @return list of property sets in IEObjectDescription format
	 */
	 public static EList <IEObjectDescription> getAllPropertySetsInWorkspace(EObject context){
	 	 EList <IEObjectDescription> packlist = new BasicEList<IEObjectDescription>();
	 	IResourceDescriptions rds= rdp.getResourceDescriptions(context.eResource().getResourceSet());
	 	 Iterable<IEObjectDescription> packagedlist = rds.getExportedObjectsByType(Aadl2Package.eINSTANCE.getPropertySet());
	 	 for (IEObjectDescription eod : packagedlist) {
	 			 packlist.add(eod);
	 	 }
	 	 return packlist;
	 }


	 /**
	 * get PropertySet in workspace by looking it up in EMF index 
	 * @param pname String PropertySet name
	 * @return PropertySet or null
	 */
	 public static PropertySet getPropertySetInWorkspace(String pname){
		 IResourceDescriptions rds= rdp.getResourceDescriptions(OsateResourceUtil.getResourceSet());
	 	 Iterable<IEObjectDescription> packagedlist = rds.getExportedObjectsByType(Aadl2Package.eINSTANCE.getPropertySet());
	 	 for (IEObjectDescription eod : packagedlist) {
	 			 if (eod.getName().toString().equalsIgnoreCase(pname)) {
 					 EObject res = eod.getEObjectOrProxy();
 					 res = EcoreUtil.resolve(res, OsateResourceUtil.getResourceSet());
 					if (!Aadl2Util.isNull(res)) return (PropertySet)res;
	 			 }
	 	 }
	 	 return null;
	 }


	 /**
	 * get the Property Definition by looking it up in EMF index 
	 * @param pdname String name of property Definition (predeclared properties do not have to be qualified)
	 * @return Property or null
	 */
	 @Deprecated
	 public static Property getPropertyDefinitionInWorkspace(String pdname){
	 	 return getPropertyDefinitionInWorkspace(OsateResourceUtil.getResourceSet(), pdname);
	 }
	 
	 /**
	 * get the Property Definition by looking it up in EMF index 
	 * @param context an object in the same resource set
	 * @param pdname String name of property Definition (predeclared properties do not have to be qualified)
	 * @return Property or null
	 */
	 public static Property getPropertyDefinitionInWorkspace(EObject context,String pdname){
	 	 return getPropertyDefinitionInWorkspace(context.eResource().getResourceSet(), pdname);
	 }


	 /**
	 * get the Property Definition by looking it up in EMF index 
	 * @param pdname String name of property Definition (predeclared properties do not have to be qualified)
	 * @return Property or null
	 */
	 public static Property getPropertyDefinitionInWorkspace(ResourceSet rs,String pdname){
	 	 IResourceDescriptions rds= rdp.getResourceDescriptions(rs);
	 	 Iterable<IEObjectDescription> packagedlist = rds.getExportedObjectsByType(Aadl2Package.eINSTANCE.getProperty());
	 	 for (IEObjectDescription eod : packagedlist) {
	 		 if (pdname.lastIndexOf("::") == -1){
	 			 String name = eod.getName().toString();
	 			 for (String predeclaredPSName : AadlUtil.getPredeclaredPropertySetNames()) {
	 				 if (name.equalsIgnoreCase(predeclaredPSName+"::"+pdname)) {
	 					 EObject res = eod.getEObjectOrProxy();
	 					 res = EcoreUtil.resolve(res, rs);
	 					 if (!Aadl2Util.isNull(res)) return (Property)res;
	 				 }
	 			 }
	 		 } else{
	 			 if (eod.getName().toString().equalsIgnoreCase(pdname)) {
	 				 EObject res = eod.getEObjectOrProxy();
	 				 res = EcoreUtil.resolve(res, OsateResourceUtil.getResourceSet());
	 				 if (!Aadl2Util.isNull(res)) return (Property)res;
	 			 }
	 		 }
	 	 }
	 	 return null;
	 }

	 /**
	 * get the Property Type by looking it up in EMF index 
	 * @param ptname String name of property type (predeclared properties do not have to be qualified)
	 * @return Property or null
	 */
	 @Deprecated
	 public static PropertyType getPropertyTypeInWorkspace(String ptname){
	 	 return getPropertyTypeInWorkspace(OsateResourceUtil.getResourceSet(), ptname);
	 }
	 
	 /**
	 * get the Property Type by looking it up in EMF index 
	 * @param context an object in the same resoruce set
	 * @param ptname String name of property type (predeclared properties do not have to be qualified)
	 * @return Property or null
	 */
	 public static PropertyType getPropertyTypeInWorkspace(EObject context,String ptname){
	 	 return getPropertyTypeInWorkspace(context.eResource().getResourceSet(), ptname);
	 }


	 /**
	 * get the Property Type by looking it up in EMF index 
	 * @param ptname String name of property type (predeclared properties do not have to be qualified)
	 * @return Property or null
	 */
	 public static PropertyType getPropertyTypeInWorkspace(ResourceSet rs,String ptname){
	 	 IResourceDescriptions rds= rdp.getResourceDescriptions(rs);
	 	 Iterable<IEObjectDescription> packagedlist = rds.getExportedObjectsByType(Aadl2Package.eINSTANCE.getPropertyType());
	 	 for (IEObjectDescription eod : packagedlist) {
	 		 if (ptname.lastIndexOf("::") == -1){
	 			 String name = eod.getName().toString();
	 			 for (String predeclaredPSName : AadlUtil.getPredeclaredPropertySetNames()) {
	 				 if (name.equalsIgnoreCase(predeclaredPSName+"::"+ptname)) {
	 					 EObject res = eod.getEObjectOrProxy();
	 					 res = EcoreUtil.resolve(res, rs);
	 					 if (!Aadl2Util.isNull(res)) return (PropertyType)res;
	 				 }
	 			 }
	 		 } else{
	 			 if (eod.getName().toString().equalsIgnoreCase(ptname)) {
	 				 EObject res = eod.getEObjectOrProxy();
	 				 res = EcoreUtil.resolve(res, OsateResourceUtil.getResourceSet());
	 				 if (!Aadl2Util.isNull(res)) return (PropertyType)res;
	 			 }
	 		 }
	 	 }
	 	 return null;
	 }

	 /**
	 * get the Property Constant by looking it up in EMF index 
	 * @param pcname String name of property Constant (predeclared properties do not have to be qualified)
	 * @return Property or null
	 */
	 @Deprecated
	 public static PropertyConstant getPropertyConstantInWorkspace(String pcname){
	 	 return getPropertyConstantInWorkspace(OsateResourceUtil.getResourceSet(), pcname);
	 }
	 
	 /**
	 * get the Property Constant by looking it up in EMF index 
	 * @param context an object in the same resource set
	 * @param pcname String name of property Constant (predeclared properties do not have to be qualified)
	 * @return Property or null
	 */
	 public static PropertyConstant getPropertyConstantInWorkspace(EObject context,String pcname){
	 	 return getPropertyConstantInWorkspace(context.eResource().getResourceSet(), pcname);
	 }


	 /**
	 * get the Property Constant by looking it up in EMF index 
	 * @param pcname String name of property Constant (predeclared properties do not have to be qualified)
	 * @return Property or null
	 */
	 public static PropertyConstant getPropertyConstantInWorkspace(ResourceSet rs,String pcname){
	 	 IResourceDescriptions rds= rdp.getResourceDescriptions(rs);
	 	 Iterable<IEObjectDescription> packagedlist = rds.getExportedObjectsByType(Aadl2Package.eINSTANCE.getPropertyConstant());
	 	 for (IEObjectDescription eod : packagedlist) {
	 		 if (pcname.lastIndexOf("::") == -1){
	 			 String name = eod.getName().toString();
	 			 for (String predeclaredPSName : AadlUtil.getPredeclaredPropertySetNames()) {
	 				 if (name.equalsIgnoreCase(predeclaredPSName+"::"+pcname)) {
	 					 EObject res = eod.getEObjectOrProxy();
	 					 res = EcoreUtil.resolve(res, rs);
	 					 if (!Aadl2Util.isNull(res)) return (PropertyConstant)res;
	 				 }
	 			 }
	 		 } else{
	 			 if (eod.getName().toString().equalsIgnoreCase(pcname)) {
	 				 EObject res = eod.getEObjectOrProxy();
	 				 res = EcoreUtil.resolve(res, OsateResourceUtil.getResourceSet());
	 				 if (!Aadl2Util.isNull(res)) return (PropertyConstant)res;
	 			 }
	 		 }
	 	 }
	 	 return null;
	 }


	 /**
	 * get all packages and property sets in workspace by looking them up in EMF index 
	 * @param res resource
	 * @return list of AADL packages and property sets in IEObjectDescription format
	 */
	 @Deprecated
	 public static EList <IEObjectDescription> getAllModelUnitsInWorkspace(){
	 	 EList <IEObjectDescription> packlist = new BasicEList<IEObjectDescription>();
	 	IResourceDescriptions rds= rdp.getResourceDescriptions(OsateResourceUtil.getResourceSet());
	 	 Iterable<IEObjectDescription> packagedlist = rds.getExportedObjectsByType(Aadl2Package.eINSTANCE.getModelUnit());
	 	 for (IEObjectDescription eod : packagedlist) {
	 			 packlist.add(eod);
	 	 }
	 	 return packlist;
	 }

	 /**
	 * get all packages and property sets in workspace by looking them up in EMF index 
	 * @param res resource
	 * @return list of AADL packages and property sets in IEObjectDescription format
	 */
	 public static EList <IEObjectDescription> getAllModelUnitsInWorkspace(ResourceSet rs){
	 	 EList <IEObjectDescription> packlist = new BasicEList<IEObjectDescription>();
	 	IResourceDescriptions rds= rdp.getResourceDescriptions(rs);
	 	 Iterable<IEObjectDescription> packagedlist = rds.getExportedObjectsByType(Aadl2Package.eINSTANCE.getModelUnit());
	 	 for (IEObjectDescription eod : packagedlist) {
	 			 packlist.add(eod);
	 	 }
	 	 return packlist;
	 }

	 /**
	 * get all packages in workspace by looking them up in EMF index 
	 * @param res resource
	 * @return list of AADL packages
	 * ** EXPERIMENTAL
	 */
	 public static EList <IEObjectDescription> getAllImportedPackages(AadlPackage pack){
	 	Resource res = pack.eResource();
	 	 EList <IEObjectDescription> packlist = new BasicEList<IEObjectDescription>();
	 	 IResourceDescription packrd = getManager(res).getResourceDescription(res);
	 	 Iterable<QualifiedName> namelist = packrd.getImportedNames();
	 	IResourceDescriptions rds= rdp.getResourceDescriptions(res);
	 	 for (QualifiedName qn : namelist) {
	 		 System.out.println("ImportedName "+qn.getLastSegment()+" more "+qn);
	 		 Iterable<IEObjectDescription> packagedlist = rds.getExportedObjects(Aadl2Package.eINSTANCE.getAadlPackage(), qn, true);
	 		 for (IEObjectDescription eod : packagedlist) {
	 			 System.out.println("Imported package "+eod.getQualifiedName());
	 			 AadlPackage respack = (AadlPackage)eod.getEObjectOrProxy();
	 			 if (!packlist.contains(respack)){
	 				 packlist.add(eod);
	 				 System.out.println("Doing package imports for "+respack.getQualifiedName());
	 				 packrd = rds.getResourceDescription(eod.getEObjectURI().trimFragment());
	 				 packlist.addAll(getAllImportedPackages(pack,packrd));
	 			 }
	 		 }
	 	 }
	 	 System.out.println("Done \n");
	 	 
	 	 return packlist;
	 }

	 /* ** EXPERIMENTAL */
	 private static EList <IEObjectDescription> getAllImportedPackages(EObject context,IResourceDescription packrd){
	 	 EList <IEObjectDescription> packlist = new BasicEList<IEObjectDescription>();
		 	IResourceDescriptions rds= rdp.getResourceDescriptions(OsateResourceUtil.getResourceSet());
	 	 Iterable<QualifiedName> namelist = packrd.getImportedNames();
	 	 for (QualifiedName qn : namelist) {
	 		 System.out.println("ImportedName "+qn.getLastSegment()+" more "+qn);
	 		 Iterable<IEObjectDescription> packagedlist = rds.getExportedObjects(Aadl2Package.eINSTANCE.getAadlPackage(), qn, true);
	 		 for (IEObjectDescription eod : packagedlist) {
	 			 System.out.println("Imported package "+eod.getQualifiedName());
	 			 AadlPackage respack = (AadlPackage)eod.getEObjectOrProxy();
	 			 if (!packlist.contains(respack)){
	 				 packlist.add(eod);
	 				 System.out.println("Doing package imports for "+respack.getQualifiedName());
	 				 packrd = rds.getResourceDescription(eod.getEObjectURI().trimFragment());
	 				 getAllImportedPackages(context,packrd);
	 			 }
	 		 }
	 	 }
	 	 System.out.println("Done \n");
	 	 
	 	 return packlist;
	 }

	 /**
	 * get all classifiers in all packages by looking them up in EMF index 
	 * @param res resource
	 * @return list of classifiers in IEObjectDescription format
	 */
	 @Deprecated
	 public static EList <IEObjectDescription> getAllClassifiersInWorkspace(){
	 	 EList <IEObjectDescription> packlist = new BasicEList<IEObjectDescription>();
	 	 IResourceDescriptions rds= rdp.getResourceDescriptions(OsateResourceUtil.getResourceSet());
	 	 Iterable<IEObjectDescription> packagedlist = rds.getExportedObjectsByType(Aadl2Package.eINSTANCE.getClassifier());
	 	 for (IEObjectDescription eod : packagedlist) {
	 			 packlist.add(eod);
	 	 }
	 	 return packlist;
	 }

	 /**
	 * get all classifiers in all packages by looking them up in EMF index 
	 * @param res resource
	 * @return list of classifiers in IEObjectDescription format
	 */
	 public static EList <IEObjectDescription> getAllClassifiersInWorkspace(EObject context){
	 	 EList <IEObjectDescription> packlist = new BasicEList<IEObjectDescription>();
	 	 IResourceDescriptions rds= rdp.getResourceDescriptions(context.eResource().getResourceSet());
	 	 Iterable<IEObjectDescription> packagedlist = rds.getExportedObjectsByType(Aadl2Package.eINSTANCE.getClassifier());
	 	 for (IEObjectDescription eod : packagedlist) {
	 			 packlist.add(eod);
	 	 }
	 	 return packlist;
	 }

	 /**
	 * get all classifiers in all packages by looking them up in EMF index 
	 * @param res resource
	 * @param classifiertype desired type of classifier (you can supply it via Aadl2Package.eINSTANCE.getProcessorType, etc)
	 * @return list of classifiers in IEObjectDescription format
	 */
	 @Deprecated
	 public static EList <IEObjectDescription> getAllClassifiersOfTypeInWorkspace(EClass classifiertype){
	 	 EList <IEObjectDescription> packlist = new BasicEList<IEObjectDescription>();
	 	 IResourceDescriptions rds= rdp.getResourceDescriptions(OsateResourceUtil.getResourceSet());
	 	 Iterable<IEObjectDescription> packagedlist = rds.getExportedObjectsByType(classifiertype);
	 	 for (IEObjectDescription eod : packagedlist) {
	 			 packlist.add(eod);
	 	 }
	 	 return packlist;
	 }

	 /**
	 * get all classifiers in all packages by looking them up in EMF index 
	 * @param res resource
	 * @param classifiertype desired type of classifier (you can supply it via Aadl2Package.eINSTANCE.getProcessorType, etc)
	 * @return list of classifiers in IEObjectDescription format
	 */
	 public static EList <IEObjectDescription> getAllClassifiersOfTypeInWorkspace(EObject context,EClass classifiertype){
	 	 EList <IEObjectDescription> packlist = new BasicEList<IEObjectDescription>();
	 	 IResourceDescriptions rds= rdp.getResourceDescriptions(context.eResource().getResourceSet());
	 	 Iterable<IEObjectDescription> packagedlist = rds.getExportedObjectsByType(classifiertype);
	 	 for (IEObjectDescription eod : packagedlist) {
	 			 packlist.add(eod);
	 	 }
	 	 return packlist;
	 }


	 /**
	  * get the Classifier by looking it up in EMF index 
	  * @param cname String name of classifier, which must be qualified with a package name
	  * @return Classifier or null
	  */
	 @Deprecated
	 public static Classifier getClassifierInWorkspace(String cname){
		 return getClassifierInWorkspace(OsateResourceUtil.getResourceSet(), cname);
	 }

	 /**
	  * get the Classifier by looking it up in EMF index 
	  * @param context an object in the same resource set
	  * @param cname String name of classifier, which must be qualified with a package name
	  * @return Classifier or null
	  */
	 public static Classifier getClassifierInWorkspace(Element context,String cname){
		 return getClassifierInWorkspace(context.eResource().getResourceSet(), cname);
	 }


	 /**
	  * get the Property Definition by looking it up in EMF index 
	  * @param pdname String name of property Definition (predeclared properties do not have to be qualified)
	  * @return Property or null
	  */
	 public static Classifier getClassifierInWorkspace(ResourceSet rs,String cname){
		 IResourceDescriptions rds= rdp.getResourceDescriptions(rs);
		 Iterable<IEObjectDescription> packagedlist = rds.getExportedObjectsByType(Aadl2Package.eINSTANCE.getClassifier());
		 for (IEObjectDescription eod : packagedlist) {
			 if (eod.getName().toString().equalsIgnoreCase(cname)) {
				 EObject res = eod.getEObjectOrProxy();
				 res = EcoreUtil.resolve(res, rs);
				 if (!Aadl2Util.isNull(res)) return (Classifier)res;
			 }
		 }
		 return null;
	 }


	
}